package code_example01;

import code_example01.fruit.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitOnlyTree<T extends Fruit> {

    private List<T> fruits;

    public FruitOnlyTree() {
        fruits = new ArrayList<>();
    }

    public List<T> getFruits() {
        return Collections.unmodifiableList(fruits);
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

}
