package code_example01;

import code_example01.fruit.Apple;
import code_example01.fruit.Orange;

public class Basket {

    public static void main(String[] args) {
        FruitTree<Apple> appleFruitTree = new FruitTree<>();
        appleFruitTree.addFruit(new Apple());
        appleFruitTree.addFruit(new Apple());

        FruitTree<String> stringFruitTree = new FruitTree<>();
        stringFruitTree.addFruit("Hello");

        FruitOnlyTree<Orange> orangeFruitOnlyTree = new FruitOnlyTree<>();
        orangeFruitOnlyTree.addFruit(new Orange());
        orangeFruitOnlyTree.addFruit(new Orange());

        // Will not compile!
        // FruitOnlyTree<String> stringFruitOnlyTree = new FruitOnlyTree<>();

    }

}
