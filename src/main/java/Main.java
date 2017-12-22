import com.github.youyinnn.youquickjetty.YouJetty;

/**
 * @author: youyinnn
 */
public class Main {

    public static void main(String[] args) {
        YouJetty youJetty = YouJetty.initServer(args);
        YouJetty.addAnnotationScanner();
        youJetty.startAndJoin();
    }

}
