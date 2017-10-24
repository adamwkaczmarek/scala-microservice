package routes

import javax.ws.rs.Path

import about.AboutApp
import akka.http.scaladsl.server.{Directives, Route}
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.jackson.Serialization
import org.json4s.{DefaultFormats, jackson}
import welcome.WelcomeController

import scala.concurrent.ExecutionContext

@Path("/welcome")
class WelcomeRoutes(welcomeCtrl:WelcomeController)(implicit executionContext: ExecutionContext) extends Json4sSupport with Directives{
  implicit val serialization: Serialization.type = jackson.Serialization
  implicit val formats: DefaultFormats.type      = DefaultFormats

  @Path("/{user}")
  def routes:Route=
    (get & pathPrefix("welcome")) {
      path(Segment) {
        user =>
          pathEnd {
            complete {
              welcomeCtrl.handleRequest(user)
            }
          }
      }

    }



}
