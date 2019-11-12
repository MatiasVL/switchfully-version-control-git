package code_example01.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasicJdbcConnection {

    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@database.cuvv0osxzgmi.eu-west-3.rds.amazonaws.com:1521:admin", "HRSTUDENT50", "HRSTUDENT50");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from COUNTRIES")) {
            List<Country> allCountries = new ArrayList<>();
            while (resultSet.next()) {
                String countryName = resultSet.getString("COUNTRY_NAME");
                String id = resultSet.getString("COUNTRY_ID");
                allCountries.add(new Country(id, countryName));
            }
            allCountries.forEach(System.out::println);
        } catch (SQLException exception) {
            System.err.println("Oops " + exception.getMessage());
        }

    }

    /**
     * Some other examples of queries and manipulations
     */

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
        while (resultSet.next()) {
            System.out.println(resultSet.getString("COUNTRY_NAME"));
        }
        statement.close();
    }


}
