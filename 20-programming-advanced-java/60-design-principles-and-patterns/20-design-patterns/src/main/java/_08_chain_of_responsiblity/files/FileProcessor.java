package _08_chain_of_responsiblity.files;

import _08_chain_of_responsiblity.files.handlers.AudioFileHandler;
import _08_chain_of_responsiblity.files.handlers.FileHandler;
import _08_chain_of_responsiblity.files.handlers.JsonFileHandler;
import _08_chain_of_responsiblity.files.handlers.TextFileHandler;

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
