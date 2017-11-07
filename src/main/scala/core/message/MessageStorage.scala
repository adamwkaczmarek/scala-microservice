package core.message

import core.Message
import utils.db.DatabaseConnector

import scala.concurrent.{ExecutionContext, Future}

sealed  trait MessageStorage {
    def getAllMessages:Future[Seq[Message]]
}

case class JdbcMessagesStorage(val databaseConnector:DatabaseConnector)
                              (implicit executionContext: ExecutionContext) extends MessageTable with MessageStorage{
  import databaseConnector._
  import databaseConnector.profile.api._

  override def getAllMessages = db.run(messages.result)
}
