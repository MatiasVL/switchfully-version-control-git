package code_example01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitTree<T> {

    private List<T> fruits;

    public FruitTree() {
        fruits = new ArrayList<>();
    }

    public List<T> getFruits() {
        return Collections.unmodifiableList(fruits);
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

}
