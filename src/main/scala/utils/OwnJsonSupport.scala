package utils

import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.{DefaultFormats, jackson}
import org.json4s.jackson.Serialization

trait OwnJsonSupport extends Json4sSupport{
  implicit val serialization: Serialization.type = jackson.Serialization
  implicit val formats: DefaultFormats.type      = DefaultFormats
}
