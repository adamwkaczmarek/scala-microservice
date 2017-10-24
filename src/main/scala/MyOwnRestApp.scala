
import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext


object MyOwnRestApp extends App with RestService {


  implicit val actorSystem = ActorSystem("my-system")
  implicit val actorMaterializer: ActorMaterializer = ActorMaterializer()
  implicit val ec: ExecutionContext = actorSystem.dispatcher

  val host = "0.0.0.0"
  val port = 8080


  val bindingFuture = Http().bindAndHandle(routes, host, port)


}
