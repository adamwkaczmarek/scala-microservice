package core.device

import core.Device
import utils.db.DatabaseConnector

import scala.concurrent.{ExecutionContext, Future}

sealed trait DeviceStorage {

  def getAllDevices: Future[Seq[Device]]
  def getDeviceById(id:String): Future[Option[Device]]
  def addDevice(device:Device):Future[Device]
}

case class JdbcDeviceStorage(val databaseConnector: DatabaseConnector)
                            (implicit executionContext: ExecutionContext) extends DeviceTable with DeviceStorage{
  import databaseConnector._
  import databaseConnector.profile.api._

  override def getAllDevices: Future[Seq[Device]] = db.run(devices.result)

  override def getDeviceById(id:String): Future[Option[Device]] = db.run(devices.filter(_.id===id).result.headOption)

  override def addDevice(device: Device): Future[Device] = db.run(devices.insertOrUpdate(device)).map(_=>device)
}