package org.hello.servlet.web.front.v3.controller;

import org.hello.servlet.web.front.ModelView;
import org.hello.servlet.web.front.v3.V3Controller;

import java.util.Map;

public class MemberFormV3Controller implements V3Controller {

    @Override
    public ModelView process(Map<String, Object> paramMap) {
        return new ModelView("new-form");
    }

}
