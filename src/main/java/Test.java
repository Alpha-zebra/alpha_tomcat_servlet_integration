import java.sql.*;

public class Test {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        testConnection();
    }
    public static void testConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/ssm_p?serverTimezone=UTC";
        String name="root";
        String pwd="alpha";

        Connection con= DriverManager.getConnection(url,name,pwd);
        System.out.println(con);


        String sql="select * from  category_";
        Statement s=con.createStatement();
        ResultSet rs=s.executeQuery(sql);

        while (rs.next()){
            System.out.println(rs.getString("name"));

        }



    }

}
