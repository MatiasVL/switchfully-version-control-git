package codeexamplesfromslides;

public class Box<T> {

    T boxContent;

    public void store(T boxContent) {
        this.boxContent = boxContent;
    }

    public T get() {
        return boxContent;
    }

    public static void main(String[] args) {

        Box<Cat> catBox = new Box();
        Box<Cat> catBox1 = new Box<>();
        var catBox2 = new Box<Cat>();

        catBox.store(new Cat("Garfield"));
        Cat theCat = catBox.get();
        theCat.miauw();


//        var box = new Box<Cat>();
//        box.store(new Cat("Garfield"));
//        box.store(new Rocket());
    }

}
