package switchtothesun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import switchtothesun.commandreader.CommandReader;
import switchtothesun.commandreader.handler.*;

import java.util.Scanner;

import static java.util.Arrays.asList;

@ComponentScan(basePackages = "codelab01")
public class SwitchToTheSun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwitchToTheSun.class);
        CommandReader commandReader = context.getBean(CommandReader.class);
        System.out.println("****************************************");
        System.out.println("Welcome to Switch To The Sun Application");
        System.out.println("****************************************");
        commandReader.startReadingUserInput();
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public CommandReader commandReader(Scanner scanner, ReportHandler reportHandler, AddCountryHandler addCountryHandler, RemoveCountryHandler removeCountryHandler, FindAttractionsInCountryHandler findAttractionsInCountryHandler, FindAttractionsWithTypeHandler findAttractionsWithTypeHandler) {
        return new CommandReader(scanner, asList(
                reportHandler,
                addCountryHandler,
                removeCountryHandler,
                findAttractionsInCountryHandler,
                findAttractionsWithTypeHandler
        ));
    }
}
