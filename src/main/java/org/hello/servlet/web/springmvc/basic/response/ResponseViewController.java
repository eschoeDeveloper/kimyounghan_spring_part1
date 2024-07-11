package org.hello.servlet.web.springmvc.basic.response;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    // 404 오류 발생 시 spring-boot-starter-thymeleaf 의존성 추가
    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {

        ModelAndView modelAndView = new ModelAndView("response/hello");
        modelAndView.addObject("data", "Hello World");
        return modelAndView;

    }

    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "Hello World");
        return "response/hello";

    }

}
