package _04_proxy;

public class ImageProxy implements Image{

    private ActualImage actualImage;
    private String pathToImage;

    public ImageProxy(String pathToImage) {
        this.pathToImage = pathToImage;
    }

    @Override
    public void display() {
        System.out.println("Showing a placeholder until the actual image is loaded!");
        if(actualImage == null) {
            actualImage = new ActualImage(pathToImage);
        }
        actualImage.display();
    }
}
