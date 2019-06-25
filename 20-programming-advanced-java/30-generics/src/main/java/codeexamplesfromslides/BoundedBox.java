package codeexamplesfromslides;

public class BoundedBox<T extends Animal> {

    private T boxContent;

    public BoundedBox(T boxContent) {
        this.boxContent = boxContent;
    }

    public void store(T boxContent) {
        this.boxContent = boxContent;
    }

    public T get() {
        return boxContent;
    }

}
