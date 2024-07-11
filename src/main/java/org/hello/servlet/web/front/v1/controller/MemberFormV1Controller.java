package org.hello.servlet.web.front.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.v1.V1Controller;

import java.io.IOException;

public class MemberFormV1Controller implements V1Controller {

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); // JSP 경로를 Dispatcher Servlet에 지정
        dispatcher.forward(request, response); // DispatcherServlet에 지정된 jsp로 이동
    }

}
