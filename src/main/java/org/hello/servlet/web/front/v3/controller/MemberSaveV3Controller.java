package org.hello.servlet.web.front.v3.controller;

import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;

import java.util.Map;

public class MemberSaveV3Controller implements V3Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, Object> paramMap) {

        String username = paramMap.get("username").toString();
        int age = Integer.parseInt(paramMap.get("age").toString());

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModelMap().put("member", member);

        return mv;

    }
}
