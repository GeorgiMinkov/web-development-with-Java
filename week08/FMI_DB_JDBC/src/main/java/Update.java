import java.sql.*;

public class Update {
    public static void main(String args[]) throws ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClassName);

        String url = "jdbc:mysql://localhost:3306/FMIDemo?user=root";
        try(Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement()) {

            String query = "UPDATE jdbc_students SET FIRST_NAME = ? WHERE ID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setString(1, "Ivan");
            preparedStatement.setLong(2, 1);

            int count = preparedStatement.executeUpdate();

            System.out.println("number of update rows by this query= " + count);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}