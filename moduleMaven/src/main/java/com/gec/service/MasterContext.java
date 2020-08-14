package com.gec.service;

import com.gec.bean.MasterExample;
import com.gec.impl.MasterMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MasterContext {

    public static MasterMapper masterMapper;
    public static MasterExample masterExample;

    static {

        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.dao.xml");
        masterMapper= (MasterMapper) context.getBean("masterMapper");
        masterExample = (MasterExample) context.getBean("masterExample");

    }
}
