package routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server._
import akka.stream.Materializer
import com.softwaremill.macwire._
import welcome.WelcomeController

import scala.concurrent.ExecutionContext

class BaseRoutes(implicit actorSystem: ActorSystem,
                 ec: ExecutionContext,
                 mat: Materializer) extends Directives {

   val routes: Route = pathPrefix("api") {

     val welcomeCtrl= new WelcomeController()

     wire[MiscRoutes].routes~
     new WelcomeRoutes(welcomeCtrl).routes
   }


}
