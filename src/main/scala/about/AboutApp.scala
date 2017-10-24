package about


case class AboutApp(title:String,
                    name : String =BuildInfo.name,
                    version: String=BuildInfo.version) {

}
