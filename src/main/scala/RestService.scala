import akka.actor.ActorSystem
import akka.http.scaladsl.server.RouteConcatenation
import akka.stream.ActorMaterializer
import com.softwaremill.macwire.wire
import com.typesafe.config.ConfigFactory
import routes.BaseRoutes

import scala.concurrent.{ExecutionContext, Future}


trait RestService extends RouteConcatenation with CorsSupport {
  implicit val actorSystem: ActorSystem
  implicit val actorMaterializer: ActorMaterializer
  implicit val ec: ExecutionContext



  lazy val baseRoutes = wire[BaseRoutes]

  lazy val routes= corsHandler(wire[BaseRoutes].routes)

}
