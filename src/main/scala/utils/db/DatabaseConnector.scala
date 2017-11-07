package utils.db

import com.zaxxer.hikari.{HikariConfig, HikariDataSource}

class DatabaseConnector(jdbUrl: String, dbUser: String, dbPassword: String) {

  private val hikariDataSource = {
    val config = new HikariConfig()
    config.setJdbcUrl(jdbUrl)
    config.setUsername(dbUser)
    config.setPassword(dbPassword)

    new HikariDataSource(config)
  }


  val profile=slick.jdbc.PostgresProfile
  import profile.api._

  val db =Database.forDataSource(hikariDataSource,None)
  db.createSession()

}
