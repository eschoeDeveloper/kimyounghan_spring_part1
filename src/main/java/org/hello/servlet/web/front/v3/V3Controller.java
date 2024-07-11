package org.hello.servlet.web.front.v3;

import org.hello.servlet.web.front.ModelView;

import java.util.Map;

public interface V3Controller {

    ModelView process(Map<String, Object> paramMap);

}
