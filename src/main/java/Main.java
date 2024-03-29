import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        // connection string usually provided by DBA
        String dbURL = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";
        // jdbc Java apo that contains all the interface and classes
        // mysql this is the name of the database that we will bne working with
        // 3.237.189.167 IP of the server
        // 3306 port on which the database is active
        // syntaxhrm_mysql name of the database or schema

        String userName = "syntax_hrm";
        String password = "syntaxhrm123";
        // Username and password will be used to track and give different access levels

        Connection connection = DriverManager.getConnection(dbURL, userName, password);

        Statement statement = connection.createStatement();

        String query = "select * from employee";

        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String empId = resultSet.getString("empid");
            String salary = resultSet.getString("salary");
            String grade = resultSet.getString("grade");
            String department = resultSet.getString("department");
            System.out.println(empId + " " + salary + " " + grade + " " + department);
        }
    }
}
