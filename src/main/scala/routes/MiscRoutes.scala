package routes

import javax.ws.rs.Path

import about.AboutApp
import akka.http.scaladsl.server.{Directives, Route}
import akka.stream.Materializer
import io.swagger.annotations._
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{DefaultFormats, jackson}

import scala.concurrent.ExecutionContext

@Path("/")
@Api(value = "Miscellaneous", produces = "application/json")
class MiscRoutes(implicit ec: ExecutionContext, mat: Materializer) extends Json4sSupport with Directives {

  @Path("/about")
  @ApiOperation(value = "Return App Information", httpMethod = "GET")
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Return information about this REST application", response = classOf[AboutApp])
  ))
  def aboutAppGetRoute = path("about") {
    implicit val serialization = jackson.Serialization
    implicit val formats = DefaultFormats
    get {
      complete {
        AboutApp("about")
      }
    }
  }

  val routes: Route = aboutAppGetRoute
}
