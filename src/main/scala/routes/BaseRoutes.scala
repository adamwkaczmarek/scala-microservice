package routes

import akka.actor.ActorSystem
import akka.http.scaladsl.server._
import akka.stream.Materializer
import com.softwaremill.macwire._
import core.device.{DeviceService, JdbcDeviceStorage}
import core.message.{JdbcMessagesStorage, MessageService}
import core.user_profile.{JdbcUserProfileStorage, UserProfileService}
import utils.db.DatabaseConnector
import welcome.WelcomeController

import scala.concurrent.ExecutionContext

class BaseRoutes(implicit actorSystem: ActorSystem,
                 ec: ExecutionContext,
                 mat: Materializer,
                 databaseConnector: DatabaseConnector) extends Directives {

   val routes: Route = pathPrefix("api") {

     val welcomeCtrl= new WelcomeController()
     val userProfileStorage = new JdbcUserProfileStorage(databaseConnector)
     val userProfileService=new UserProfileService(userProfileStorage)
     val messageStorage = new JdbcMessagesStorage(databaseConnector)
     val messageSerive = new MessageService(messageStorage)
     val deviceStorage = new JdbcDeviceStorage(databaseConnector)
     val deviceService = new DeviceService(deviceStorage)


     wire[MiscRoutes].routes~
     new WelcomeRoutes(welcomeCtrl).routes~
     new ProfileRoute(userProfileService).routes~
     new MessageRoute(messageSerive).routes~
     new DeviceRoute(deviceService).routes
   }


}
