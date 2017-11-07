package routes

import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.{Directives, Route}
import core.user_profile.UserProfileService
import utils.OwnJsonSupport


class ProfileRoute(userProfileService: UserProfileService)(implicit executionContext: ExecutionContext) extends OwnJsonSupport with Directives {



  def routes:Route=pathPrefix("profiles"){
      pathEndOrSingleSlash {
         get{
           complete(userProfileService.getProfiles())
         }
      } ~
      pathPrefix(Segment) { id=>
        pathEndOrSingleSlash{
          get{
             complete(userProfileService.getProfile(id).map{
               case Some(profile)=>profile
               case None=> None
             })
          }
        }
      }

  }

}
