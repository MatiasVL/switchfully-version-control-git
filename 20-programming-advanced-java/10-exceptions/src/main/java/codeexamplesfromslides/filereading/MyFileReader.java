package codeexamplesfromslides.filereading;

public class MyFileReader {

    public static String read(final String filename) {
        MyFile file = MyFile.accessFromDisk(filename);
        if(file == null) {
            throw new RuntimeException("File was not found, as there is no content");
        }
        return file.readContent();
    }


    private static class MyFile {
        public MyFile(String filename) {
            // do nothing, dummy code
        }

        public static MyFile accessFromDisk(String filename) {
            return null; // always return null
        }

        public String readContent() {
            return null; // always return null
        }
    }
}
