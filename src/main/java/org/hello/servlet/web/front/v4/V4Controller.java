package org.hello.servlet.web.front.v4;

import java.util.Map;

public interface V4Controller {

    /**
     *
     * @param paramMap
     * @param modelMap
     * @return viewName
     */
    String process(Map<String, Object> paramMap, Map<String, Object> modelMap);

}
