package core
import scala.concurrent.{ExecutionContext, Future}

class UserProfileService(userProfileStorage: UserProfileStorage)(implicit executionContext: ExecutionContext) {

  def getProfiles():Future[Seq[UserProfile]]=userProfileStorage.getAllProfiles()
  def getProfile(id:String):Future[Option[UserProfile]]=userProfileStorage.getProfile(id)
}
