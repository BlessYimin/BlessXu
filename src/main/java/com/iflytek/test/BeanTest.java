package com.iflytek.test;

import com.alibaba.fastjson.JSON;
import com.iflytek.dto.UserDTO;
import com.iflytek.model.User;
import com.iflytek.utils.BeanUtils;

/**
 * @ClassName BeanTest
 * @Description
 * @Author BlessXu
 * @Data 2018/5/29 16:49
 * @Version 1.0
 **/

public class BeanTest {
    public static void main(String[] args) {
        UserDTO userDTO=new UserDTO();
        userDTO.setId(1);
        userDTO.setName("bless");
        User user=new User();
        user.setPassword("2");
        System.out.println(JSON.toJSONString(user));
        user=BeanUtils.map(userDTO,User.class);
        System.out.println(JSON.toJSONString(user));
    }
}
