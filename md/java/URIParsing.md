# java.net.URI 사용
```
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        try {
            String uriString = "https://www.example.com/path?key1=value1&key2=value2";
            URI uri = new URI(uriString);

            String scheme = uri.getScheme();
            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();
            String query = uri.getQuery();

            System.out.println("Scheme: " + scheme);
            System.out.println("Host: " + host);
            System.out.println("Port: " + port);
            System.out.println("Path: " + path);
            System.out.println("Query: " + query);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
```
