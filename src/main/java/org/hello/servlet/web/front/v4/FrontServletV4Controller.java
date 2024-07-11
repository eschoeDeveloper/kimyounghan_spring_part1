package org.hello.servlet.web.front.v4;

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
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontServletV4Controller", urlPatterns = "/front-controller/v4/*")
public class FrontServletV4Controller extends HttpServlet {

    // 정적 컨트롤러 정보 관리
    private Map<String, V4Controller> controllerMap = new HashMap<>();

    public FrontServletV4Controller() {
        controllerMap.put("/front-controller/v4/members/new-form", new MemberFormV4Controller());
        controllerMap.put("/front-controller/v4/members/save", new MemberSaveV4Controller());
        controllerMap.put("/front-controller/v4/members", new MemberListV4Controller());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 최상위 인터페이스를 상속받은 컨트롤러 매핑
        V4Controller controller = controllerMap.get(requestURI);

        // 잘못된 컨트롤러인 경우
        if( ObjectUtils.isEmpty(controller) ) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, Object> paramMap = createParamMap(request); // 동적 Parameter Map 생성
        Map<String, Object> modelMap = new HashMap<>();

        String viewName = controller.process(paramMap, modelMap); // 해당 Controller Process 실행

        MyView myView = viewResolver(viewName);
        myView.render(modelMap, request, response);

    }

    private static MyView viewResolver(String viewName) {
        MyView myView = new MyView("/WEB-INF/views/" + viewName + ".jsp");
        return myView;
    }

    private static Map<String, Object> createParamMap(HttpServletRequest request) {

        Map<String, Object> paramMap = new HashMap<>();

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));

        return paramMap;

    }

}
