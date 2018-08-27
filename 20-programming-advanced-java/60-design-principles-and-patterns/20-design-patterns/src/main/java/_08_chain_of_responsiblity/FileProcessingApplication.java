package _08_chain_of_responsiblity;

public class FileProcessingApplication {

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();

        System.out.println("Processing a .txt file:");
        fileProcessor.processFile(new File("a_simple_text_file.txt"));

        System.out.println("Processing a .mp3 file:");
        fileProcessor.processFile(new File("song.mp3"));

        System.out.println("Processing a .json file:");
        fileProcessor.processFile(new File("userdata.json"));

        System.out.println("Processing a .exe file:");
        fileProcessor.processFile(new File("program.exe"));
    }
}
