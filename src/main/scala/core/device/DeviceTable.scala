package core.device

import core.Device
import utils.db.DatabaseConnector

trait DeviceTable {

  protected val databaseConnector:DatabaseConnector

  import databaseConnector.profile.api._

  class Devices (tag:Tag)extends Table[Device](tag,"device"){
    def id = column[String]("id",O.PrimaryKey)
    def name = column[String]("name")
    def description = column[String]("description")
    def ip = column[String]("ip")
    def * = (id, name, description,ip).mapTo[Device]

  }

  protected val devices = TableQuery[Devices]



}
