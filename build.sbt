
name := "my-own-rest-service"
organization:= "Onwelo"
version := "0.1"
scalaVersion := "2.12.3"
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")


lazy val root = (project in file(".")).
  enablePlugins(BuildInfoPlugin).
  settings(
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "about",
    buildInfoOptions += BuildInfoOption.BuildTime
  )

libraryDependencies ++= {
  val akkaV       = "2.5.3"
  val akkaHttpV   = "10.0.8"
  val macWireVersion = "2.3.0"
  val json4sVersion = "3.5.2"
  val akkaHttpJsonVersion = "1.17.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV,
    "com.softwaremill.macwire" %% "macros" % macWireVersion % "provided",
    "com.softwaremill.macwire" %% "util" % macWireVersion,
    "com.softwaremill.macwire" %% "proxy" % macWireVersion,
    "com.github.swagger-akka-http" %% "swagger-akka-http" % "0.9.1",
    "org.json4s" %% "json4s-native" % json4sVersion,
    "org.json4s" %% "json4s-jackson" % json4sVersion,
    "org.json4s" %% "json4s-ext" % json4sVersion,
    "de.heikoseeberger" %% "akka-http-json4s" % akkaHttpJsonVersion
  )
}





        