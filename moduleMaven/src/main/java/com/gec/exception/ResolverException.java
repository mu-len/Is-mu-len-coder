package com.gec.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResolverException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        String massage="默认异常";
        if(e instanceof MyException&&null!=((MyException) e).getMassage()){
            massage=((MyException) e).getMassage();
        }
        System.out.println("在处理 "+request.getRequestURI()+" 请求时发生异常："+massage);

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("massage","在处理 "+request.getRequestURI()+" 请求时发生异常："+massage);
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
