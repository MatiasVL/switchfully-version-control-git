package _08_chain_of_responsiblity.files.handlers;

import _08_chain_of_responsiblity.files.File;

/**
 * NonFileHandler is actually an example of the "Null Object" Design pattern
 */
public class NonFileHandler implements FileHandler {

    @Override
    public void setNextHandler(FileHandler nextHandler) {
        throw new UnsupportedOperationException("A NonFileHandler is positioned at the end of the chain, " +
                "it should not have a next handler.");
    }

    @Override
    public void process(File file) {
        System.out.println("\tEnd of chain reached, file not processed by any handler!");
    }

    @Override
    public String getName() {
        return "NON file handler";
    }
}
