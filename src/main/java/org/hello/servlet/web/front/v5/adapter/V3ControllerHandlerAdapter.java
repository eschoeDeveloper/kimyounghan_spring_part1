package org.hello.servlet.web.front.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;
import org.hello.servlet.web.front.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class V3ControllerHandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof V3Controller);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        V3Controller v3Controller = (V3Controller) handler;

        Map<String, Object> paramMap = createParamMap(request);
        ModelView mv = v3Controller.process(paramMap);

        return mv;

    }

    private static Map<String, Object> createParamMap(HttpServletRequest request) {

        Map<String, Object> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;

    }

}
