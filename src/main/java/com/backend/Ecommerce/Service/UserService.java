package com.backend.Ecommerce.Service;

import com.backend.Ecommerce.Mapper.UserMapper;
import com.backend.Ecommerce.model.Userdata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.backend.Ecommerce.model.User;
import org.springframework.web.bind.annotation.RequestBody;

@Slf4j
@Service
public class UserService {

    private final UserMapper userMapper;
    UserService(UserMapper userMapper){
        this.userMapper=userMapper;
    }

    public Userdata addUser(User user) {
        System.out.println(user);
        try{
            if(userMapper.validationOfUser(user.getEmail())!=null){
                return null;
            }
            userMapper.addUser(user);
            return Userdata.builder().email(user.getEmail()).username(user.getUsername()).masterUser(user.isMasterUser()).build();
        } catch (Exception e) {
            log.error("exception found");
            return null;
        }
    }

    public Userdata loginUser(User userr) {
        System.out.println(userr);
        User user=userMapper.getUser(userr);
        if(user==null){
            throw new RuntimeException("User not found");
        }
        return Userdata.builder().email(user.getEmail()).username(user.getUsername()).masterUser(user.isMasterUser()).build();
    }

    private User validationOfUser(String email) {
        return userMapper.validationOfUser(email);
    }

}
