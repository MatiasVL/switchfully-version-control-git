package _04_proxy;

public class ImageViewerApplication {

    public static void main(String[] args) {
        Image image = new ImageProxy("https://www.someimagesite.com/image.jpg");

        image.display();

        System.out.println("----------");

        // Due to our proxy we won't fetch / load the image again from the remote server the second time
        image.display();
    }

}
