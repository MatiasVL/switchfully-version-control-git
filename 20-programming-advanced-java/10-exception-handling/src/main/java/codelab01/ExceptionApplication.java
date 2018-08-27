package codelab01;

/**
 * Read the README.md file
 */
public class ExceptionApplication {

    public static void main(String[] args) {

        MyExceptionService myExceptionService = new MyExceptionService();
        myExceptionService.doSomethingExceptional();
        System.out.println("I can show you the world!");

    }

}
