package switchtothesun.commandreader;

import org.springframework.beans.factory.annotation.Autowired;
import switchtothesun.commandreader.handler.Handler;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommandReader {

    private Scanner scanner;
    private List<Handler> listOfHandlers;

    @Autowired
    public CommandReader(Scanner scanner, List<Handler> listOfHandlers) {
        this.scanner = scanner;
        this.listOfHandlers = listOfHandlers;
    }

    public void startReadingUserInput() {
        while (true) {
            System.out.print("\\>");
            String nextCommand = scanner.nextLine();

            listOfHandlers.stream()
                    .filter(t -> t.canHandle(nextCommand))
                    .forEach(t -> t.handle(getLastWordOfSentence(nextCommand)));

            if (nextCommand.equals("quit")) {
                System.out.println("Goodbye");
                return;
            }


        }
    }

    private String getLastWordOfSentence(String nextCommand) {
        return Arrays.stream(nextCommand.split(" ")).reduce((t1, t2) -> t2).orElse(nextCommand);
    }
}
