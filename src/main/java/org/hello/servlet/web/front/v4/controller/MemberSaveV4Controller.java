package org.hello.servlet.web.front.v4.controller;

import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;
import org.hello.servlet.web.front.v4.V4Controller;

import java.util.Map;

public class MemberSaveV4Controller implements V4Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> modelMap) {

        String username = paramMap.get("username").toString();
        int age = Integer.parseInt(paramMap.get("age").toString());

        Member member = new Member(username, age);
        memberRepository.save(member);

        modelMap.put("member", member);
        return "sava-result";

    }

}
