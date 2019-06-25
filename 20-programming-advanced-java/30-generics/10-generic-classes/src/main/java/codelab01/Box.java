package codelab01;

public class Box {

    private Object contentOfBox;

    void store(Object contentOfBox) {
        this.contentOfBox = contentOfBox;
    }

    Object getContentOfBox() {
        return contentOfBox;
    }
}
