package _08_chain_of_responsiblity.files.handlers;

import _08_chain_of_responsiblity.files.File;

public interface FileHandler {

    void setNextHandler(FileHandler nextHandler);
    void process(File file);
    String getName();

}
