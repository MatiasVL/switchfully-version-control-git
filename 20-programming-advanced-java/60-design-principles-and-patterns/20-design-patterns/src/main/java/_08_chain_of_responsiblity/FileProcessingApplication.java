package _08_chain_of_responsiblity;

import _08_chain_of_responsiblity.files.File;
import _08_chain_of_responsiblity.files.FileProcessor;

public class FileProcessingApplication {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        System.out.println("Processing a .txt file:");
        fileProcessor.processFile(new File("a_simple_text_file.txt"));

        System.out.println("Processing a .json file:");
        fileProcessor.processFile(new File("userdata.json"));

        System.out.println("Processing a .exe file:");
        fileProcessor.processFile(new File("program.exe"));
    }
}
