import io.javalin.Javalin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        Javalin.create(config -> {
            config.concurrency.useVirtualThreads = true;
            config.routes.get("/", ctx -> {
                log.info("{} {} from {} -> Hello World", ctx.method(), ctx.path(), ctx.ip());
                ctx.result("Hello World");
            });
        }).start(7070);
    }
}
