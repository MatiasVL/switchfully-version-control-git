package solid.solution_codelab03_liskov_substitution_principle;

public class Duck implements Quackable, Swimmable {

    @Override
    public void quack() {
        System.out.println("Quack.....");
    }

    @Override
    public void swim() {
        System.out.println("Swim....");
    }

}
