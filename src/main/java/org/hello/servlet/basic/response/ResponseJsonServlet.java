package org.hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.basic.HelloData;

import java.io.IOException;

@WebServlet(name = "reponseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json"); // Content Type 지정
        resp.setCharacterEncoding("UTF-8"); // 인코딩 지정

        // 객체 데이터화
        HelloData helloData = new HelloData();
        helloData.setUsername("eschoe");
        helloData.setAge(20);

        // 데이터 객체를 데이터 객체 스트링으로 변환
        String resultString = mapper.writeValueAsString(helloData);
        resp.getWriter().write(resultString); // 변환 후 브라우저에 출력

    }
}
