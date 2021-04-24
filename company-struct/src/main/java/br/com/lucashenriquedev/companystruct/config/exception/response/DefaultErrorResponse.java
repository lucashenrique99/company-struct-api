package br.com.lucashenriquedev.companystruct.config.exception.response;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;

@Component
public class DefaultErrorResponse extends DefaultErrorAttributes{

//    @Override
//    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
//        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
//        errorAttributes.remove("error");
//        errorAttributes.remove("trace");
//        errorAttributes.remove("path");
//        errorAttributes.remove("status");
//        errorAttributes.remove("timestamp");
//
//        return errorAttributes;
//    }
}
