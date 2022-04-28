import java.sql.*;

public class Create_PreparedStmnt {
    public static void main(String args[]) throws ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClassName);

        String url = "jdbc:mysql://localhost:3306/FMIDemo?user=root";
        try(Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement()) {

            String query = "insert into jdbc_students (FIRST_NAME, FAMILY_NAME) values (?, ?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "Foo");
            preparedStatement.setString(2,"Bar");

            int count = preparedStatement.executeUpdate();

            System.out.println("number of rows affected by this query= " + count);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}