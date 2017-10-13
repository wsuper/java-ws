package com.ws.controller;

import com.ws.model.User;
import com.ws.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by super on 2017/10/12.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id) {
        return userService.getUserInfo(id);
    }


}
