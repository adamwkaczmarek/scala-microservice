package core.message

import core.Message
import utils.db.DatabaseConnector

trait MessageTable {
  protected val databaseConnector:DatabaseConnector

  import databaseConnector.profile.api._

  class Messages (tag:Tag)extends Table[Message](tag,"message"){
    def id = column[Long]("id",O.PrimaryKey)
    def content= column[String]("content")
    def sender = column[String]("sender")
    def * = (sender, content, id).mapTo[Message]
  }

  protected val messages=TableQuery[Messages]

}
