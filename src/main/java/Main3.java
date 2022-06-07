import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

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

        List<Map<String, String>> tableData = new ArrayList<>();

        System.out.println();

        // with while loop we go through the rows one by one
        while (resultSet.next()) {

            Map<String, String> row = new LinkedHashMap<>();
            // with for loop we go through all the columns one by one
            for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
                String nameOfColumn = resultSetMetaData.getColumnLabel(i);
                String columnValue = resultSet.getString(nameOfColumn);
                row.put(nameOfColumn,columnValue);
            }
            tableData.add(row);
        }

        System.out.println(tableData);


    }
}
