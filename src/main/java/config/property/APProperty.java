package config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("mussum")
public class APProperty {

    Database database = new Database();

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public static class Database {
        private String urlDB;
    }
}
