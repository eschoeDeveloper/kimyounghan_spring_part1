package org.hello.servlet.web.front.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.MyView;

import java.io.IOException;

public interface V2Controller {

    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
