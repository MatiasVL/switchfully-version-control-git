package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DatasourceConfig {

    private final Environment environment;

    public DatasourceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(environment.getProperty("app.datasource.url"));
        dataSource.setUsername(environment.getProperty("app.datasource.username"));
        dataSource.setPassword(environment.getProperty("app.datasource.password"));
        return dataSource;
    }
}
