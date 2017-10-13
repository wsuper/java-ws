package com.ws.service;

import com.ws.dao.UserMapper;
import com.ws.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by super on 2017/10/12.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

}
