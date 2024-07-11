package org.hello.servlet.basic.request;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJSONServlet extends HttpServlet {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletInputStream is = req.getInputStream();
        String messageBody = StreamUtils.copyToString(is, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        HelloData data = mapper.readValue(messageBody, HelloData.class);

        System.out.println("data.getUsername() = " + data.getUsername());
        System.out.println("data.getAge() = " + data.getAge());

    }

}
