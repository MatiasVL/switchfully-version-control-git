package codelab01.switchtothesun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Scanner;

@Import(value = Codelab01Config.class)
public class SwitchToTheSun {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwitchToTheSun.class);

        System.out.println("Welcome to Switch To The Sun");

        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            if(line.equals("quit")){
                return;
            }
        }
    }
}
