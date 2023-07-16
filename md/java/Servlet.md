# Servlet - GET
## Jetty 서버 생성 및 시작
```java
Server server = new Server(8080); // 포트 번호 지정
server.start();
```

## Jetty 서블릿 추가
```java
ServletContextHandler context = new ServletContextHandler(server, "/");
context.addServlet(HelloServlet.class, "/hello");
```

## 서블릿 클래스 정의
```java
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello, Jetty!</h1>");
    }
}
```

## Jetty 서버 정지
```java
server.stop();
```

## 새로운 서블릿 클래스 정의
### Jetty 새로운 경로 추가 ('/world')
```java
public class WorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello, World!</h1>");
    }
}
```

## Jetty 서블릿 추가
```java
context.addServlet(WorldServlet.class, "/world");
```


# Servlet - POST
## POST 요청을 처리할 서블릿 클래스
```java
public class HelloServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello, " + name + "!</h1>");
    }
}
```

## Jetty 서블릿 추가
```java
context.addServlet(HelloServlet.class, "/hello");
```

## POST 요청을 보내는 코드
```java
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpClient httpClient = new HttpClient();
        httpClient.start();
        try {
            String url = "http://localhost:8080/hello";
            Request request = httpClient.POST(url);
            request.param("name", "John");

            ContentResponse response = request.send();
            System.out.println(response.getContentAsString());
        } finally {
            httpClient.stop();
        }
    }
}
```


