package com.backend.Ecommerce.Mapper;

import com.backend.Ecommerce.model.User;
import com.backend.Ecommerce.model.Userdata;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void addUser(User user);
    public User getUser(User user);
    public User validationOfUser(String email);

}
