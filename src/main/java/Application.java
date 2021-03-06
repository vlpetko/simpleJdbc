import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Application {
    private static final String TABLE = "tasks";

    public static void main(String[] args) {

        DataBaseConnector databaseConnector = new DataBaseConnector();
        Connection connection = databaseConnector.getNewConnection();
        DataBaseService dataBaseService = new DataBaseService();

        if (connection != null) {
            System.out.println("connection ok");
//            if (!checkSchema(connection)) {
//                createSchema(connection);
//            }
//            Task task = new Task("newTask3","newDescr3");
//            dataBaseService.add(task,TABLE, connection);
//            dataBaseService.delete("1636642602183",TABLE,connection);
            dataBaseService.updateTask("1636643648818",TABLE,new Task("newTask3a","newDescr3a"),connection);

            List<Task> allTasks = dataBaseService.findAll(TABLE,connection);
            for (Task t:allTasks
                 ) {
                System.out.println(t);

            }
        } else {
            System.out.println("no connection");
        }

        createSchema(connection);

    }

    private static boolean createSchema(Connection connection) {
        boolean result = false;
        String createSchema = "CREATE TABLE IF NOT EXISTS " + TABLE + " ("
                + "task_id VARCHAR(50) NOT NULL, "
                + "task_name VARCHAR(50) NOT NULL, "
                + "task_description VARCHAR(100) NOT NULL, "
                + "create_date TIMESTAMP "
                + ")";
        try (
                PreparedStatement ps = connection.prepareStatement(createSchema)) {
            ps.executeUpdate();
            result = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static boolean checkSchema(Connection connection){
        boolean result = false;

        return result;
    }
}
