package org.hello.servlet.web.front.v5.adapter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v3.V3Controller;
import org.hello.servlet.web.front.v4.V4Controller;
import org.hello.servlet.web.front.v5.MyHandlerAdapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class V4ControllerHandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return (handler instanceof V4Controller);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {

        V4Controller v4Controller = (V4Controller) handler;

        Map<String, Object> paramMap = createParamMap(request);
        Map<String, Object> modelMap = new HashMap<>();

        String viewName = v4Controller.process(paramMap, modelMap); // 해당 Controller Process 실행

        ModelView mv = new ModelView(viewName);
        mv.setModelMap(modelMap);

        return mv;

    }

    private static Map<String, Object> createParamMap(HttpServletRequest request) {

        Map<String, Object> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;

    }

}
