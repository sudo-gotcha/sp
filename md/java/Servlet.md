# Servlet
## Jetty 서버 생성 및 시작
```
Server server = new Server(8080); // 포트 번호 지정
server.start();
```

## Jetty 서블릿 추가
```
ServletContextHandler context = new ServletContextHandler(server, "/");
context.addServlet(HelloServlet.class, "/hello");
```

## 서블릿 클래스 정의
```
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
```
server.stop();
```

## 새로운 서블릿 클래스 정의
### Jetty 새로운 경로 추가 ('/world')
```
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
```
context.addServlet(WorldServlet.class, "/world");
```
