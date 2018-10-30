package _04_proxy;

public class ActualImage implements Image {

    private String pathToImage;

    public ActualImage(String pathToImage) throws InterruptedException {
        this.pathToImage = pathToImage;
        loadImageFromRemoteServer();
    }

    @Override
    public void display() {
        System.out.println("\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r");
        System.out.println("- Actual Image -");
        System.out.println("===============");
        System.out.println("======   ======");
        System.out.println("====       ====");
        System.out.println("===         ===");
        System.out.println("===    PI   ===");
        System.out.println("===    CA   ===");
        System.out.println("===    SO   ===");
        System.out.println("===         ===");
        System.out.println("====       ====");
        System.out.println("======   ======");
        System.out.println("===============");
    }

    private void loadImageFromRemoteServer() throws InterruptedException {
        Thread.sleep(2500);
    }

}
