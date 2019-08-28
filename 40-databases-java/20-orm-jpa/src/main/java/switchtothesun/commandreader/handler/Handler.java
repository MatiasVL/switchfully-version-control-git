package switchtothesun.commandreader.handler;

public interface Handler {

    boolean canHandle(String prefix);

    void handle(String parameter);
}
