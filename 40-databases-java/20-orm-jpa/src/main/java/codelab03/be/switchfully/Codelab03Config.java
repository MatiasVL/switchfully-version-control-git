package codelab03.be.switchfully;

import config.DatasourceConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(DatasourceConfig.class)
@ComponentScan(basePackages = "codelab03")
@EnableTransactionManagement
public class Codelab03Config {


}
