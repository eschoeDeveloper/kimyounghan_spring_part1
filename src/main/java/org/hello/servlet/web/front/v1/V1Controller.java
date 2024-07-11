package org.hello.servlet.web.front.v1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface V1Controller {

    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
