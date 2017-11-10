package core.message

import core.Message
import utils.db.DatabaseConnector

import scala.concurrent.{ExecutionContext, Future}

sealed  trait MessageStorage {
    def getAllMessages:Future[Seq[Message]]
    def getMessageById(id:Long):Future[Option[Message]]
    def getAllMessageContents:Future[Seq[String]]
}

case class JdbcMessagesStorage(val databaseConnector:DatabaseConnector)
                              (implicit executionContext: ExecutionContext) extends MessageTable with MessageStorage{
  import databaseConnector._
  import databaseConnector.profile.api._

  override def getAllMessages = db.run(messages.result)

  override def getMessageById(id:Long) = db.run(messages.filter(_.id===id).result.headOption)

  override def getAllMessageContents = db.run(messages.map(_.content).result)
}
