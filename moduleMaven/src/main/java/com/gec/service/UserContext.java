package com.gec.service;

import com.gec.bean.UserExample;
import com.gec.impl.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserContext {

    public static UserMapper userMapper;
    public static UserExample userExample;

    static {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.dao.xml");
        userMapper= (UserMapper) context.getBean("userMapper");
        userExample= (UserExample) context.getBean("userExample");

    }

}
