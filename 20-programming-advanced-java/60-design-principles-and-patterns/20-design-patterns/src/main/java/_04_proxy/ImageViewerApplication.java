package _04_proxy;

public class ImageViewerApplication {

    public static void main(String[] args) throws InterruptedException {
        Displayable image = new ImageProxy("https://www.someimagesite.com/image.jpg");

        // Downloading the actual image takes up to 5 seconds.
        // By using the proxy, we can show a stand-in image for those 5 seconds.
        image.display();

        // Due to our proxy we won't fetch / load the image again from the remote server the second time.
        // The second time, we simply reload the actual image (which our proxy has in its 'cache').
        // To see this in effect, simply call the display method again. It won't do the 'remote' call to download.
        // image.display();
    }

}
