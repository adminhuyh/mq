package com.boot.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class PageErrorController implements ErrorController {  
    private static final String ERROR_PATH = "/error";  
    @RequestMapping(value=ERROR_PATH)  
    public String handleError(){  
    	System.out.println("errrrrrrrrrrrrrrrrrrrrrr");
        return "forward:/error.jsp";  
    }  
    public String getErrorPath(){  
        return ERROR_PATH;  
    }  
}  
