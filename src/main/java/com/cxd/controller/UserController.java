package com.cxd.controller;

import com.cxd.entity.Result;
import com.cxd.entity.User;
import com.cxd.service.UserService;
import com.cxd.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by cai x d
 * on2017/4/2 0002.
 */
@RestController
@RequestMapping(value = "/user",method = RequestMethod.POST)
@Api(value = "用户api",description = "用户api")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "findAll")
    public List<User> userFindAll(){
        return userService.userFindAll();
    }

    @RequestMapping(value = "add")
    public Result userAdd(@RequestBody @Valid User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
       return ResultUtil.success(userService.userAdd(user));
    }

    @RequestMapping(value = "update")
    public User userUpdate(Integer id, @RequestBody  User user){
        return userService.userUpdate(id,user);
    }

    @RequestMapping(value = "findOne")
    public User userFindOne(Integer id){
        return userService.userFindOne(id);
    }

    @RequestMapping(value = "findByAge")
    public List<User> userFindByAge(Integer age){
        return  userService.findByAge(age);
    }

    /**
     * 通过年龄来判断
     */
    @RequestMapping(value = "getAge")
    public void getAge(Integer id) throws Exception{
        userService.getAge(id);
    }
}
