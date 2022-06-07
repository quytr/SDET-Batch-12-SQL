import java.sql.*;

public class Main2 {

    public static void main(String[] args) throws SQLException {

        // DBUrl Database String
        String dbUrl = "jdbc:mysql://3.237.189.167:3306/syntaxhrm_mysql";

        // Always protected by some kind of extra security layers so that no one can access the database easily
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        Connection connection = DriverManager.getConnection(dbUrl, username, password);

        Statement statement = connection.createStatement();

        String query = "select * from person;";

        ResultSet resultSet = statement.executeQuery(query);

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        // getting database header
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.print(resultSetMetaData.getColumnLabel(i) + " ");

        }
        System.out.println();

        // with while loop we go through the rows one by one
        while (resultSet.next()) {
            // with for loop we go through all the columns one by one
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = resultSet.getString(nameOfColumn);
                System.out.print(columnValue + " ");
            }
            System.out.println();
        }


    }
}
