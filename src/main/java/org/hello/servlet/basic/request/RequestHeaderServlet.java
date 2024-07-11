package org.hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "reqeustHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);

    }

    private static void printStartLine(HttpServletRequest req) {

        System.out.println("--- REQUEST-LINE - start ---");

        System.out.println("request.getMethod() = " + req.getMethod()); //GET
        System.out.println("request.getProtocal() = " + req.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + req.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + req.getRequestURL());
        // /request-test
        System.out.println("request.getRequestURI() = " + req.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " + req.getQueryString());
        System.out.println("request.isSecure() = " + req.isSecure()); //https 사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();

    }

    private void printHeaders(HttpServletRequest req) {

        System.out.println("--- Headers - Start ---");

        // 방법 1
//        Enumeration<String> headerNames = req.getHeaderNames();
//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println("headerName ::: " + headerName);
//        }

        // 방법 2
        req.getHeaderNames().asIterator().forEachRemaining(headerName -> System.out.println("headerName = " + headerName));

        System.out.println("--- Headers - End ---");
        System.out.println();

    }

    private void printHeaderUtils(HttpServletRequest req) {

        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + req.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " + req.getServerPort()); //Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("request.getLocale() = " + req.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");

        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + req.getContentType());
        System.out.println("request.getContentLength() = " + req.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + req.getCharacterEncoding());

        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }

}
