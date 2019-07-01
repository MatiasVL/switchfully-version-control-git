package code_example04_inner_class.v2_public;

public class HeadRunner {

    public static void main(String[] args) {
        Head head = new Head();
        head.acquireSunburn();
        System.out.println(head.hasHeadache());

        // This is how we can create a Brain object
        Head.Brain brain = head.new Brain();
    }

}
