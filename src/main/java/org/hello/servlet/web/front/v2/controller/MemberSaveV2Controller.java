package org.hello.servlet.web.front.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v2.V2Controller;

import java.io.IOException;

public class MemberSaveV2Controller implements V2Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save( member );

        // Request Model에 데이터 추가
        request.setAttribute("member", member);

        return new MyView("/WEB-INF/views/save-result.jsp");
    }

}
