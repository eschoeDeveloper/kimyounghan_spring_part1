package org.hello.servlet.web.front.v2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.MyView;
import org.hello.servlet.web.front.v2.V2Controller;

import java.io.IOException;
import java.util.List;

public class MemberListV2Controller implements V2Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> memberList =  memberRepository.findAll();
        // Request Model에 데이터 추가
        request.setAttribute("memberList", memberList);
        return new MyView("/WEB-INF/views/members.jsp");

    }
}
