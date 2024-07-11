package org.hello.servlet.basic.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // [status-line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        resp.setHeader("Content-type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        //resp.setHeader("my-header", "hello");

        // [Header 편의 메서드]
//        content(resp);
//        cookie(resp);
        redirect(resp);

        // [message body]
        resp.getWriter().println("안녕하세요.");

    }

    private void content(HttpServletResponse resp) {
        // Content-Type: text/plain;charset=utf-8
        // Content-Length: 2
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
    }

    private void cookie(HttpServletResponse resp) {
        // Set-Cookie: myCookie:good; Max-Age=600;
        // resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        // Status Code 302
        // location: /basic/hello-form.html

//        resp.setStatus(HttpServletResponse.SC_FOUND);
//        resp.setHeader("Location", "/basic/hello-form.html");
        resp.sendRedirect("/basic/hello-form.html");

    }

}
