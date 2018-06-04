package codelab00;

public class Box {

    private Object contentOfBox;

    void store(Object contentOfBox) {
        this.contentOfBox = contentOfBox;
    }

    public Object getContentOfBox() {
        return contentOfBox;
    }
}
