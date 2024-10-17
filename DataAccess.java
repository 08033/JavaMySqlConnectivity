
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
import java.sql.*;
import java.text.DecimalFormat;

public class DataAccess {

    private String ConnString = "";
    Connection mysqlConn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public DataAccess() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.ConnString = "jdbc:mysql://localhost/world";
            //this.ConnString = "jdbc:mysql://localhost/world?" + "user=root&password=Abc@1234";
            this.mysqlConn = DriverManager.getConnection(ConnString, "root", "Abc@1234");
        } catch (SQLException mysqlEx) {
            Logger.PrintMessage("SQLException: " + mysqlEx.getMessage());
        } catch (ClassNotFoundException clsEx) {
            Logger.PrintMessage("ClassNotFoundException: " + clsEx.getMessage());
        }
    }

    public void PrintCities() {
        try {
            Integer ID = 0, Population = 0;
            //DecimalFormat formatter = new DecimalFormat("#,###.00");
            DecimalFormat formatter = new DecimalFormat("#,###");
            String Name = "", CountryCode = "", District = "";
            stmt = mysqlConn.createStatement();
            rs = stmt.executeQuery("select ID, Name, CountryCode, District, Population from City limit 10;");

            while (rs.next()) {
                ID = rs.getInt("ID");
                Name = rs.getString("Name");
                CountryCode = rs.getString("CountryCode");
                District = rs.getString("District");
                Population = rs.getInt("Population");
                Logger.PrintMessage("---------------------");
                Logger.PrintMessage(String.format("Country:[%s]; ID:%s", Name, ID));
                Logger.PrintMessage(String.format("Code:%s; Population:%s; District:%s", CountryCode, formatter.format(Population), District));
            }

        } catch (Exception e) {
            Logger.PrintMessage(e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (mysqlConn != null) {
                    mysqlConn.close();
                }

                rs = null;
                stmt = null;
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
            }

        }
    }
}
