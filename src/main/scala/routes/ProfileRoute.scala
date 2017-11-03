package routes


import core.UserProfileService
import de.heikoseeberger.akkahttpjson4s.Json4sSupport


import scala.concurrent.ExecutionContext
import akka.http.scaladsl.server.{Directives, Route}
import org.json4s.jackson.Serialization
import org.json4s.{DefaultFormats, jackson}


class ProfileRoute(userProfileService: UserProfileService)(implicit executionContext: ExecutionContext) extends Json4sSupport with Directives {

  implicit val serialization: Serialization.type = jackson.Serialization
  implicit val formats: DefaultFormats.type      = DefaultFormats

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
