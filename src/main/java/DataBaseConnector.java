import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataBaseConnector {
    public Connection getNewConnection() {
        Connection connection;
        try (InputStream in = DataBaseConnector.class.getClassLoader().getResourceAsStream("application.properties")) {
            Properties config = new Properties();
            config.load(in);
            // Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return connection;
    }
}
