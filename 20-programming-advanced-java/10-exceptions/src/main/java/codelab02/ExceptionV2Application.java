package codelab02;

/**
 * Read the README.md file
 */
public class ExceptionV2Application {

    public static void main(String[] args) {

        MyExceptionV2Service myExceptionService = new MyExceptionV2Service();
        myExceptionService.doSomethingExceptional();
        System.out.println("I can show you the world!");

    }

}
