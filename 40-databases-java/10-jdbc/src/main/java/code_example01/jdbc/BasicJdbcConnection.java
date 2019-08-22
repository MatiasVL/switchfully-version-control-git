package code_example01.jdbc;

import java.sql.*;

public class BasicJdbcConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "HR", "hr");
//        getAllCountries(connection);
//        System.out.println();
//        System.out.println("****************************");
//        System.out.println();
//        changeCountry(connection);
//        getAllCountries(connection);
//        System.out.println();
//        System.out.println("****************************");
//        System.out.println();
//        changeCountryBack(connection);
//        getAllCountries(connection);
        connection.close();
    }

    private static void changeCountryBack(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("update COUNTRIES set COUNTRY_NAME = 'Netherlands' where COUNTRY_NAME = 'Holland'");
        statement.close();
    }

    private static void changeCountry(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeQuery("update COUNTRIES set COUNTRY_NAME = 'Holland' where COUNTRY_NAME = 'Netherlands'");
        statement.close();
    }

    private static void getAllCountries(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from COUNTRIES");
        while(resultSet.next()){
            System.out.println(resultSet.getString("COUNTRY_NAME"));
        }
        statement.close();
    }


}
