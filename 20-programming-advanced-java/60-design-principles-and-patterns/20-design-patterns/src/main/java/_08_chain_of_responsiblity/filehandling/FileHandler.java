package _08_chain_of_responsiblity.filehandling;

import _08_chain_of_responsiblity.File;

public interface FileHandler {

    void setNextHandler(FileHandler nextHandler);
    void process(File file);
    String getName();

}
