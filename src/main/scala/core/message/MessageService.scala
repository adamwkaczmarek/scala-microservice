package core.message

import core.Message

import scala.concurrent.Future

class MessageService(messageStorage: MessageStorage) {
    def getAllMessages:Future[Seq[Message]]= messageStorage.getAllMessages
    def getMessageById(id:Long):Future[Option[Message]]=messageStorage.getMessageById(id)
    def getAllMessagesContents:Future[Seq[String]]=messageStorage.getAllMessageContents
}
