package _08_chain_of_responsiblity.files;

import _08_chain_of_responsiblity.files.handlers.FileHandler;
import _08_chain_of_responsiblity.files.handlers.JsonFileHandler;
import _08_chain_of_responsiblity.files.handlers.NonFileHandler;
import _08_chain_of_responsiblity.files.handlers.TextFileHandler;

public class FileProcessor {

    private FileHandler initialFileHandler;

    public FileProcessor() {
        createFileHandlerChain();
    }

    private void createFileHandlerChain() {
        JsonFileHandler jsonFileHandler = new JsonFileHandler();
        TextFileHandler textFileHandler = new TextFileHandler();
        NonFileHandler nonFileHandler = new NonFileHandler();

        jsonFileHandler.setNextHandler(textFileHandler);
        textFileHandler.setNextHandler(nonFileHandler);

        initialFileHandler = jsonFileHandler;
    }

    public void processFile(File file) {
        initialFileHandler.process(file);
    }
}
