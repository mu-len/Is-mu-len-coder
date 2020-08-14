package com.gec.service;

import com.gec.bean.User;
import com.gec.bean.UserExample;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserService extends UserContext{

    @Test
    public void findId(){
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(1002);
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users.get(0));
    }
}