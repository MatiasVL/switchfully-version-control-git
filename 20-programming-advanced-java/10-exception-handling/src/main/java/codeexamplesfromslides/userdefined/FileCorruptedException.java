package codeexamplesfromslides.userdefined;

public class FileCorruptedException extends RuntimeException {

    public FileCorruptedException(String message) {
        super("File is corrupted: " + message);
    }
}
