package com.art2cat.dev.restful.argumentresolver.impl;

import com.art2cat.dev.restful.argumentresolver.intf.IArgumentHandler;
import com.art2cat.dev.restful.model.FileHolder;
import java.nio.charset.Charset;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * com.art2cat.dev.restful
 *
 * @author Rorschach
 * @date 11/01/2018
 */
public class FileHolderArgumentHandler implements IArgumentHandler {
    
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(FileHolder.class);
    }
    
    @Override
    public Object resolveArgument(MethodParameter methodParameter,
        ModelAndViewContainer modelAndViewContainer,
        NativeWebRequest nativeWebRequest,
        WebDataBinderFactory webDataBinderFactory) throws Exception {
        String bar = nativeWebRequest.getParameter("fileName");
        String foo = nativeWebRequest.getParameter("fileContent");
        
        if (isNotSet(bar)) {
            bar = "defaultBar";
        }
        
        if (isNotSet(foo)) {
            foo = "defaultFoo";
        }
        FileHolder fileHolder = new FileHolder();
        fileHolder.setFileName(bar);
        fileHolder.setFileContent(foo.getBytes(Charset.forName("UTF-8")));
        
        return fileHolder;
    }
    
    private boolean isNotSet(String value) {
        return value == null;
    }
}
