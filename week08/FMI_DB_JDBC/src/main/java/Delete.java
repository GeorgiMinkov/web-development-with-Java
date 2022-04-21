import java.sql.*;

public class Delete {
    public static void main(String args[]) throws ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClassName);

        String url = "jdbc:mysql://localhost:3306/FMIDemo?user=root";
        try(Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement()) {

            String query = "DELETE FROM jdbc_students WHERE ID = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);

            preparedStatement.setLong(1, 2);

            int count = preparedStatement.executeUpdate();

            System.out.println("number of deleted rows by this query= " + count);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}