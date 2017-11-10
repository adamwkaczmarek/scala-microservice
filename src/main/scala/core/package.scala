package object core {
  type UserId = String

  final case class UserProfile(id: UserId, firstName: String, lastName: String) {
    require(id.nonEmpty, "firstName.empty")
    require(firstName.nonEmpty, "firstName.empty")
    require(lastName.nonEmpty, "lastName.empty")
  }

  final case class Message(
                            sender: String,
                            content: String,
                            id: Long = 0L)

  final case class Device(
                           id: String,
                           name: String,
                           description: String,
                           ip: String
                         )

}
