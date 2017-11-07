package core.message

import core.Message

import scala.concurrent.Future

class MessageService(messageStorage: MessageStorage) {
    def getAllMessages:Future[Seq[Message]]= messageStorage.getAllMessages
}
