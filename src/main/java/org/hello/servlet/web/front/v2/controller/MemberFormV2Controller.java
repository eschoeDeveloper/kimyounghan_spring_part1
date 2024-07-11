package org.hello.servlet.web.front.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v2.V2Controller;

import java.io.IOException;

public class MemberFormV2Controller implements V2Controller {

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return new MyView("/WEB-INF/views/new-form.jsp");
    }

}
