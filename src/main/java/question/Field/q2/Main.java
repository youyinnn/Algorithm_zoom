package question.Field.q2;

import java.io.*;
import java.net.URL;

/**
 * @description:
 * @author: youyinnn
 * @date: 2017/3/28
 */
public class Main {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.baidu.com");
        BufferedReader in  = new BufferedReader(new InputStreamReader(url.openStream()));
        String inString;
        File outfile=new File("test.html");
        PrintWriter out=new PrintWriter(new FileWriter(outfile));
        while ((inString=in.readLine())!=null){
            out.println(inString);
        }
        in.close();
        out.close();
    }
}
