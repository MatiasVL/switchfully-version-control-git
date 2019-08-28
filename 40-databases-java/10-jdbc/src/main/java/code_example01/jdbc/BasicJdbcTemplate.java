package code_example01.jdbc;

import config.DatasourceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Import(DatasourceConfig.class)
public class BasicJdbcTemplate {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BasicJdbcTemplate.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

//        jdbcTemplate.query("select * from COUNTRIES", (row2, rowNum2) -> row2.getString("COUNTRY_NAME")).forEach(System.out::println);
//        System.out.println();
//        System.out.println("****************************");
//        System.out.println();
//        jdbcTemplate.update("update COUNTRIES set COUNTRY_NAME = 'Holland' where COUNTRY_NAME = 'Netherlands'");
//        jdbcTemplate.query("select * from COUNTRIES", (row2, rowNum2) -> row2.getString("COUNTRY_NAME")).forEach(System.out::println);
//        System.out.println();
//        System.out.println("****************************");
//        System.out.println();
//        jdbcTemplate.update("update COUNTRIES set COUNTRY_NAME = 'Netherlands' where COUNTRY_NAME = 'Holland'");
//        jdbcTemplate.query("select * from COUNTRIES", (row2, rowNum2) -> row2.getString("COUNTRY_NAME")).forEach(System.out::println);
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("HR");
        dataSource.setPassword("hr");
        return new JdbcTemplate(dataSource);
    }
}
