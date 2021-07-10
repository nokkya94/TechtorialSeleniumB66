package Utils;

import java.sql.*;
import java.util.*;

public class JDBCTest {
    /*
    Connection the url of database "jdbc:oracle:thin:@techtorial1.cavcsbsnjhye.us-east-2.rds.amazonaws.com:1521/ORCL"
    Statement
    ResultSet - response
     */



    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(
                "jdbc:oracle:thin:@techtorial1.cavcsbsnjhye.us-east-2.rds.amazonaws.com:1521/ORCL",
                "Alexander94",
                "101294abcd"
        );

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("select * from employees order by employee_id");

        resultSet.next();//it will go to the first row
        //return type of next method is boolean
        //if there is next row it will go there and return true, if there is not a row it will return false

        String firstName = resultSet.getString("first_name");
        System.out.println(firstName);
        String lastName = resultSet.getString("last_name");
        System.out.println(lastName);

        resultSet.last();//it will return last row

        String fName = resultSet.getString("first_name");
        System.out.println(fName);

        resultSet.first();//it will go to first row
        System.out.println(resultSet.getString("last_name"));

        System.out.println(resultSet.getString(1));//it will return the index of this raw. the position
        System.out.println(resultSet.getRow());//it will return current row number


        System.out.println(resultSet.getObject("phone_number")); //getting an object we can transforme the Object in a map
        //=====================RESULT SET METADATA=======================//

        resultSet.beforeFirst();
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        System.out.println(resultSetMetaData.getColumnName(4));
        System.out.println(resultSetMetaData.getColumnCount());
        System.out.println(resultSetMetaData.getColumnName(9));

        List<Map<String,Object>> data = new ArrayList<>();

        while (resultSet.next()){

            Map<String,Object> map = new LinkedHashMap<>();

            for (int i = 1 ;  i<=resultSetMetaData.getColumnCount(); i++){

                map.put(resultSetMetaData.getColumnName(i),resultSet.getObject(i));

            }

            data.add(map);

        }


        for(int i =0; i<data.size();i++){

            Collection<Object> values = data.get(i).values();
            for (Object value: values){
                System.out.print(value+" ");

            }
            System.out.println();
        }




    }
}






















