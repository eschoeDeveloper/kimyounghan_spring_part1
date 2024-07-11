package org.hello.servlet.web.front.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.v1.V1Controller;

import java.io.IOException;
import java.util.List;

public class MemberListV1Controller implements V1Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> memberList =  memberRepository.findAll();

        // Request Model에 데이터 추가
        request.setAttribute("memberList", memberList);

        String viewPath = "/WEB-INF/views/members.jsp";

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);


    }
}
