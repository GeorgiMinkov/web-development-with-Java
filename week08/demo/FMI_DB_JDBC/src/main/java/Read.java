import java.sql.*;

public class Read {
    public static void main(String args[]) throws ClassNotFoundException {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        Class.forName(driverClassName);

        String url = "jdbc:mysql://localhost:3306/FMIDemo?user=root";
        try(Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement()) {

            String query = "SELECT * FROM jdbc_students";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("FIRST_NAME");
                String familyName = rs.getString("FAMILY_NAME");
                Date created = rs.getDate("created_date");

                System.out.format("%d, %s, %s, %te-%tm-%tY\n", id, firstName, familyName, created, created, created);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}