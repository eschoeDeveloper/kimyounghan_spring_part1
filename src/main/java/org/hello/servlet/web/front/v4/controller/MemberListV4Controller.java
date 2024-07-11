package org.hello.servlet.web.front.v4.controller;

import org.hello.servlet.domain.Member;
import org.hello.servlet.domain.MemberRepository;
import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;
import org.hello.servlet.web.front.v4.V4Controller;

import java.util.List;
import java.util.Map;

public class MemberListV4Controller implements V4Controller {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {

        List<Member> members = memberRepository.findAll();
        model.put("members", members);

        return "members";

    }

}
