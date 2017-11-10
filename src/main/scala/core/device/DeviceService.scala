package core.device

import core.Device

import scala.concurrent.Future

class DeviceService(deviceStorage: DeviceStorage) {

  def getAll():Future[Seq[Device]]= deviceStorage.getAllDevices
  def getById(id:String):Future[Option[Device]]=deviceStorage.getDeviceById(id)
  def add(device: Device):Future[Device]=deviceStorage.addDevice(device)

}
