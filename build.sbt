name := "my-own-rest-service"
organization := "Onwelo"
version := "0.1"
scalaVersion := "2.12.3"
scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")




libraryDependencies ++= {

  val akkaHttpV = "10.0.8"
  val macWireVersion = "2.3.0"
  val json4sVersion = "3.5.2"
  val akkaHttpJsonVersion = "1.17.0"
  val slickVersion = "3.2.1"
  Seq(
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
    "de.heikoseeberger" %% "akka-http-json4s" % akkaHttpJsonVersion,

    // Config file parser
    "com.github.pureconfig" %% "pureconfig" % "0.8.0",
    // Connection pool for database
    "com.zaxxer" % "HikariCP" % "2.7.0",
    // SQL generator
    "com.typesafe.slick" %% "slick" % slickVersion,
    // Postgres driver
    "org.postgresql" % "postgresql" % "42.1.4",
        // Migration for SQL databases
    "org.flywaydb" % "flyway-core" % "4.2.0",

  )
}





        
