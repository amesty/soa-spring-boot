package com.example.server.soa.web.controller;

import com.example.server.soa.common.util.ResultTool;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ExampleErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Resource
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping
    public Map<String, Object> error(HttpServletRequest request) {
        WebRequest webRequest = new ServletWebRequest(request);
        Map<String,Object> errorAttributesData = errorAttributes.getErrorAttributes(webRequest,true);
        return ResultTool.error(String.valueOf(errorAttributesData.get("status")),
                String.valueOf(errorAttributesData.get("message")));
    }
}
