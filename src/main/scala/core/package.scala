package object core {
  type UserId = String

  final case class UserProfile(id: UserId, firstName: String, lastName: String) {
    require(id.nonEmpty, "firstName.empty")
    require(firstName.nonEmpty, "firstName.empty")
    require(lastName.nonEmpty, "lastName.empty")
  }

}
