package org.hello.servlet.web.front.v5;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v3.V3Controller;
import org.hello.servlet.web.front.v3.controller.MemberFormV3Controller;
import org.hello.servlet.web.front.v3.controller.MemberListV3Controller;
import org.hello.servlet.web.front.v3.controller.MemberSaveV3Controller;
import org.hello.servlet.web.front.v4.controller.MemberFormV4Controller;
import org.hello.servlet.web.front.v4.controller.MemberListV4Controller;
import org.hello.servlet.web.front.v4.controller.MemberSaveV4Controller;
import org.hello.servlet.web.front.v5.adapter.V3ControllerHandlerAdapter;
import org.hello.servlet.web.front.v5.adapter.V4ControllerHandlerAdapter;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontServletV5Controller", urlPatterns = "/front-controller/v5/*")
public class FrontServletV5Controller extends HttpServlet {

    private final Map<String, Object> handleMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontServletV5Controller() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object handler = getHandler(request);

        // 잘못된 컨트롤러인 경우
        if( ObjectUtils.isEmpty(handler) ) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter handlerAdapter = getHandlerAdapter(handler);
        ModelView mv = handlerAdapter.handle(request, response, handler);

        String viewName = mv.getViewName(); // 논리명 new-form
        MyView myView = viewResolver(viewName);

        myView.render(mv.getModelMap(), request, response);

    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new V3ControllerHandlerAdapter());
        handlerAdapters.add(new V4ControllerHandlerAdapter());
    }

    private void initHandlerMappingMap() {
        handleMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormV3Controller());
        handleMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveV3Controller());
        handleMappingMap.put("/front-controller/v5/v3/members", new MemberListV3Controller());

        // V4 추가
        handleMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormV4Controller());
        handleMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveV4Controller());
        handleMappingMap.put("/front-controller/v5/v4/members", new MemberListV4Controller());
    }

    private Object getHandler(HttpServletRequest request) {
        String requestURI = request.getRequestURI();

        // 최상위 인터페이스를 상속받은 컨트롤러 매핑
        Object handler = handleMappingMap.get(requestURI);
        return handler;
    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {

        for (MyHandlerAdapter adapter : handlerAdapters) {

            if(adapter.supports(handler)) {
                return adapter;
            }

        }

        throw new RuntimeException("Handler Adapter 검색 실패 :::: handler=" + handler);

    }

    private static MyView viewResolver(String viewName) {
        MyView myView = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return myView;
    }

}
