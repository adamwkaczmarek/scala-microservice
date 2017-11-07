package utils.db

import org.flywaydb.core.Flyway

class DatabaseMigrationManager(jdbcUrl: String, dbUser: String, dbPassword: String) {

  private val flyway=new Flyway()
  flyway.setDataSource(jdbcUrl,dbUser,dbPassword)

  def migrationDatabaseSchema():Unit=flyway.migrate()

  def drop():Unit=flyway.clean()

}
