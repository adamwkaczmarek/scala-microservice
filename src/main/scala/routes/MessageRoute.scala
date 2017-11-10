package routes

import core.message.MessageService
import akka.http.scaladsl.server.{Directives, Route}
import utils.OwnJsonSupport

import scala.concurrent.ExecutionContext

class MessageRoute (messageService: MessageService)
                   (implicit executionContext: ExecutionContext) extends OwnJsonSupport with Directives {

  def routes : Route = pathPrefix("messages"){
      pathEndOrSingleSlash {
        get {
          complete(messageService.getAllMessagesContents)
        }
      }~
       pathPrefix(Segment) { id=>
         pathEndOrSingleSlash{
           get{
             complete(messageService.getMessageById(id.toInt.toLong).map{
               case Some(message)=>message
               case None => None
             })
           }
         }
       }
  }

}
