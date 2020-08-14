package com.gec.service;

import com.gec.bean.Master;
import com.gec.bean.MasterExample;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MasterService extends MasterContext{

    MasterExample.Criteria criteria = masterExample.createCriteria();
    @Test
    public void findId(){
        criteria.andIdEqualTo(1002);
        List<Master> masters = masterMapper.selectByExample(masterExample);
        System.out.println(masters.get(0));
    }

    @RequestMapping(value = {"/findNameAndPassword"},method = {RequestMethod.POST})
    public String findNameAndPassword(String name, String password, HttpSession session){
        System.out.println(name+password);
        Master master = masterMapper.findNameAndPassword(name, password);
        session.setAttribute("master",master);
        if(null!=master){
            return "success";
        }
        return "login";
    }

}
