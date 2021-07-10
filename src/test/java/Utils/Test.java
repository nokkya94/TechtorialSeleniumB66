package Utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws SQLException {

        JDBCUtils.establishConnection();

        List<Map<String,Object>> data = JDBCUtils.runQuery("select * from employees order by employee_id");
        System.out.println(data.get(0).get("PHONE_NUMBER"));
        System.out.println(JDBCUtils.getCountRow());

        JDBCUtils.closeConnection();
        

    }
}
