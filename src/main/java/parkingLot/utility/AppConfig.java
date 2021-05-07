package parkingLot.utility; 
import java.io.FileReader;
import java.sql.*;
import java.util*;
import com.mongodb.*;
import com.mongodb.client.*;
import org.bson.Document;
import redis.clients.jedis.Jedis;

public class ApplicationConfig {
    private static Connection connection;
    private static Statement statement;
    private static MongoDatabase database;
    private static MongoCollection<Document> collection;
    private static BasicDBObject updateFields=null;
    private static BasicDBObject setQuery=null;
    private static BasicDBObject whereQuery =null;
    private Properties properties=null;
    private  String client;

    public class AppConfig {
      public static Connection connection;
      public static Statement statement;
      public static Properties properties;
      private static String client;

    public void fileConfig() {
        try {
            properties = new Properties();
            properties.load(new FileReader("src/main/resources/config.properties"));
            this.client = properties.getProperty("Client");
        } catch (Exception e) {
                 e.printStackTrace();
        }
    }
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void mySqlConnection(){
            try{
                Class.forName(properties.getProperty("DRIVER"));
                this.setConnection(DriverManager.getConnection(properties.getProperty("URL"),properties.getProperty("USERNAME"),properties.getProperty("PASSWORD")));
                this.setStatement(connection.createStatement());
                System.out.println("Connected with MySQL Database.");
            }catch (Exception e){
                e.printStackTrace();}
        }
    }
        public void redisConnection() {
        this.setJedis(new Jedis(properties.getProperty("HOST")));
    }
}

