package _04_proxy;

public class ActualImage implements Displayable {

    private String pathToImage;

    public ActualImage(String pathToImage) throws InterruptedException {
        this.pathToImage = pathToImage;
        loadImageFromRemoteServer();
    }

    @Override
    public void display() {
        System.out.println("\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r");
        System.out.println("- Actual Displayable -");
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
        // In real-life, we should use the pathToImage to do an external call to the server
        Thread.sleep(2500);
    }

}
