package routes


import akka.http.scaladsl.server.{Directives, Route}
import core.Device
import core.device.DeviceService
import utils.OwnJsonSupport

import scala.concurrent.ExecutionContext

class DeviceRoute(deviceService: DeviceService)
                 (implicit  executionContext: ExecutionContext) extends OwnJsonSupport with Directives {



  def routes: Route = pathPrefix("device"){
    pathEndOrSingleSlash {
      get {
        complete(deviceService.getAll())
      }~
      post{
          entity(as[Device]){newDevice=>
            complete(deviceService.add(newDevice))
          }

      }
    }
  }

}
