package _08_chain_of_responsiblity;

import _08_chain_of_responsiblity.filehandling.AudioFileHandler;
import _08_chain_of_responsiblity.filehandling.FileHandler;
import _08_chain_of_responsiblity.filehandling.JsonFileHandler;
import _08_chain_of_responsiblity.filehandling.TextFileHandler;

public class FileProcessor {

    private FileHandler initialFileHandler;

    public FileProcessor() {
        createFileHandlerChain();
    }

    private void createFileHandlerChain() {
        TextFileHandler textFileHandler = new TextFileHandler();
        JsonFileHandler jsonFileHandler = new JsonFileHandler();
        AudioFileHandler audioFileHandler = new AudioFileHandler();

        textFileHandler.setNextHandler(jsonFileHandler);
        jsonFileHandler.setNextHandler(audioFileHandler);

        initialFileHandler = textFileHandler;
    }

    public void processFile(File file) {
        initialFileHandler.process(file);
    }
}
