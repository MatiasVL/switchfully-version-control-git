package codeexamplesfromslides.unchecked;

import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) {
        try {
            String content = readContentOf("java.docx");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readContentOf(String docName) throws IOException {
        if (!DocumentReader.exists(docName)) {
            throw new IOException("Documenten does not exist");
        }
        Document doc = DocumentReader.read(docName);
        return doc.getContent();
    }

    private static class DocumentReader {
        public static boolean exists(String docName) {
            return false;
        }

        public static Document read(String docName) {
            return null;
        }
    }

    private static class Document {
        public String getContent() {
            return null;
        }
    }
}
