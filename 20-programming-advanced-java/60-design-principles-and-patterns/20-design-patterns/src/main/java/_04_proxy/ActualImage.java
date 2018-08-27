package _04_proxy;

public class ActualImage implements Image {

    private String pathToImage;

    public ActualImage(String pathToImage) {
        this.pathToImage = pathToImage;
        loadImageFromRemoteServer();
    }

    @Override
    public void display() {
        System.out.println("Displaying the loaded, actual image!");
    }

    private void loadImageFromRemoteServer() {
        System.out.println(String.format("Loading file %s from remote server... This may take a while", pathToImage));
    }

}
