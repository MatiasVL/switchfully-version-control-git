package code_example01.jdbc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BasicJdbcTemplate {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BasicJdbcTemplate.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

        jdbcTemplate
                .query("select * from COUNTRIES",
                        (result, rowNumber) -> new Country(result.getString("COUNTRY_ID"), result.getString("COUNTRY_NAME")))
                                .forEach(System.out::println);
        // Note: this code can throw specific SQL / Data Access exceptions. Always log (at a higher level) these exceptions.
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@database.cuvv0osxzgmi.eu-west-3.rds.amazonaws.com:1521:admin");
        dataSource.setUsername("HRSTUDENT50");
        dataSource.setPassword("HRSTUDENT50");
        return new JdbcTemplate(dataSource);
    }

    public static void someOtherQueries(JdbcTemplate jdbcTemplate) {
        System.out.println();
        System.out.println("****************************");
        System.out.println();
        jdbcTemplate.update("update COUNTRIES set COUNTRY_NAME = 'Holland' where COUNTRY_NAME = 'Netherlands'");
        jdbcTemplate.query("select * from COUNTRIES", (row2, rowNum2) -> row2.getString("COUNTRY_NAME")).forEach(System.out::println);
        System.out.println();
        System.out.println("****************************");
        System.out.println();
        jdbcTemplate.update("update COUNTRIES set COUNTRY_NAME = 'Netherlands' where COUNTRY_NAME = 'Holland'");
        jdbcTemplate.query("select * from COUNTRIES", (row2, rowNum2) -> row2.getString("COUNTRY_NAME")).forEach(System.out::println);
    }
}
