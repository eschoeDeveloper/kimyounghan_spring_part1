package org.hello.servlet.web.front.v3.controller;

import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;

import java.util.List;
import java.util.Map;

public class MemberListV3Controller implements V3Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, Object> paramMap) {

        List<Member> members = memberRepository.findAll();

        ModelView mv = new ModelView("members");
        mv.getModelMap().put("members", members);

        return mv;

    }

}
