package core.user_profile

import core.UserProfile
import utils.db.DatabaseConnector

import scala.concurrent.{ExecutionContext, Future}

sealed trait UserProfileStorage {
   def getAllProfiles():Future[Seq[UserProfile]]
   def getProfile(id:String):Future[Option[UserProfile]]
}


class JdbcUserProfileStorage(val databaseConnector: DatabaseConnector)
                            (implicit  executionContext:ExecutionContext)extends UserProfileTable with UserProfileStorage{
  import databaseConnector._
  import databaseConnector.profile.api._

  def getAllProfiles():Future[Seq[UserProfile]] = db.run(profiles.result)

  def getProfile(id: String):Future[Option[UserProfile]] = db.run(profiles.filter(_.id===id).result.headOption)
}
