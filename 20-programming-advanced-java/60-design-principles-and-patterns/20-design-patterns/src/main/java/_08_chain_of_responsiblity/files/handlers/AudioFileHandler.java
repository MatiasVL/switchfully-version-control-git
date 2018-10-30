package _08_chain_of_responsiblity.files.handlers;

import _08_chain_of_responsiblity.files.File;

public class AudioFileHandler implements FileHandler {

    private static final String EXTENSION = ".mp3";
    private FileHandler nextHandler = new NonFileHandler();

    @Override
    public void setNextHandler(FileHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void process(File file) {
        if (file.getFilename().toLowerCase().contains(EXTENSION)) {
            System.out.println(String.format("\tAudioFileHandler is processing file %s", file.getFilename()));
        } else {
            System.out.println(String.format("\tAudioFileHandler could not process file %s, " +
                    "forwarding file to %s", file.getFilename(), nextHandler.getName()));
            nextHandler.process(file);
        }
    }

    @Override
    public String getName() {
        return "AUDIO file handler";
    }
}
