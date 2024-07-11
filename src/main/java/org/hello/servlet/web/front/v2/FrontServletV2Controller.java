package org.hello.servlet.web.front.v2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v1.V1Controller;
import org.hello.servlet.web.front.v1.controller.MemberFormV1Controller;
import org.hello.servlet.web.front.v1.controller.MemberListV1Controller;
import org.hello.servlet.web.front.v1.controller.MemberSaveV1Controller;
import org.hello.servlet.web.front.v2.controller.MemberFormV2Controller;
import org.hello.servlet.web.front.v2.controller.MemberListV2Controller;
import org.hello.servlet.web.front.v2.controller.MemberSaveV2Controller;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontServletV2Controller", urlPatterns = "/front-controller/v2/*")
public class FrontServletV2Controller extends HttpServlet {

    // 정적 컨트롤러 정보 관리
    private Map<String, V2Controller> controllerMap = new HashMap<>();

    public FrontServletV2Controller() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormV2Controller());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveV2Controller());
        controllerMap.put("/front-controller/v2/members", new MemberListV2Controller());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();

        // 최상위 인터페이스를 상속받은 컨트롤러 매핑
        V2Controller controller = controllerMap.get(requestURI);

        // 잘못된 컨트롤러인 경우
        if( ObjectUtils.isEmpty(controller) ) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 해당 컨트롤러 프로세스 실행
        MyView myView = controller.process(request, response);
        myView.render(request, response);

    }

}
