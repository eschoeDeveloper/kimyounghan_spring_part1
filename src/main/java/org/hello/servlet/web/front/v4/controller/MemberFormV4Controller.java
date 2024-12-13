package org.hello.servlet.web.front.v4.controller;

import org.hello.servlet.web.front.v4.V4Controller;

import java.util.Map;

public class MemberFormV4Controller implements V4Controller {

    @Override
    public String process(Map<String, Object> paramMap, Map<String, Object> model) {
        return "new-form";
    }

}
