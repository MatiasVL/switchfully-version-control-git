package codeexamplesfromslides;

public class BoxDelux<S, T> {

    private final S boxOwner;
    private final T boxContent;

    public BoxDelux(S boxOwner, T boxContent) {
        this.boxOwner = boxOwner;
        this.boxContent = boxContent;
    }

    public S getOwner() { return boxOwner; }
    public T getContent() { return boxContent; }

    public static void main(String[] args) {
        BoxDelux<Person, Cat> annsCatBox = new BoxDelux<>(new Person("Ann"), new Cat("Felix"));
        BoxDelux<Person, Person> millsTracyBox = new BoxDelux<>(new Person("Mills"), new Person("Tracy"));
    }

}
