public class GitHubLinkGenerator {

    public static void main(String[] args) {
        if (args == null || args.length != 1) {
            System.err.println("Please provide a GitHub username as an argument...");
        } else {
            System.out.println("https://github.com/" + args[0]);
        }
    }

}
