
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import utils._
import utils.db.{DatabaseConnector, DatabaseMigrationManager}

import scala.concurrent.ExecutionContext


object Boot extends App with RestService {


  implicit val actorSystem = ActorSystem("my-system")
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = actorSystem.dispatcher

  val config= Config.load()

   new DatabaseMigrationManager(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    ).migrationDatabaseSchema()

   implicit val databaseConnector = new DatabaseConnector(
      config.database.jdbcUrl,
      config.database.username,
      config.database.password
    )

  val bindingFuture = Http().bindAndHandle(routes,config.http.host,config.http.port)


}
