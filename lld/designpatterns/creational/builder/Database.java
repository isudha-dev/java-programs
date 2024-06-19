package lld.designpatterns.creational.builder;

import lombok.Getter;

@Getter
public class Database {
    private String hostname;
    private Integer port;
    private Long id;
    private String username;
    private String password;
    private String url;

    private Database(){}
    private Database(String hostname, Integer port, Long id, String username, String password, String url){
        this.hostname = hostname;
        this.port = port;
        this.id = id;
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public static DatabaseBuilder builder() {
        return new DatabaseBuilder();
    }

    public static class DatabaseBuilder {

        private Database database;

        DatabaseBuilder() {
            this.database = new Database();
        }

        // setters
        public DatabaseBuilder withHost(String hostname){
            database.hostname = hostname;
            return this;
        }

        public DatabaseBuilder withPort(Integer port){
            database.port = port;
            return this;
        }

        // validate method
        boolean validate() {
            if(database.port > 20000) {
                return false;
            }
            return true;
        }

        // build method
        public Database build() {
            if(!validate()){
                throw new RuntimeException("Port can not be greater than 20000");
            }
            Database newDB = new Database(database.hostname, database.port, database.id, database.url, database.username, database.password);
            return newDB;
        }
    }

}
