package com.cxd.service;

import com.cxd.entity.User;
import com.cxd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by cai x d
 * on2017/4/2 0002.
 */
@Service
public class UserService {
    @Autowired UserRepository userRepository;

    /**
     * 查询所有用户
     * @return
     */
    public List<User> userFindAll(){
       return userRepository.findAll();
    }

    /**
     *  添加用户
     * @param user 用户对象
     * @return
     */
    @Transactional
    public User userAdd(User user){
        user.setName(user.getName());
        user.setAge(user.getAge());
        return userRepository.save(user);
    }

    /**
     * 修改数据
     * @param id
     * @param user
     * @return
     */
    public User userUpdate(Integer id,User user){
        User user1 =  userRepository.findOne(id);
        user.setId(user1.getId());
        user.setName(user.getName());
        user.setAge(user.getAge());
        return userRepository.save(user);
    }

    /**
     * 单个查询
     * @param id
     * @return
     */
    public User userFindOne(Integer id){
        if (id != null) {
            return userRepository.findOne(id);
        }
        return null;
    }

    /**
     * 根据年龄查询
     * @param age
     * @return
     */
    public List<User> findByAge(Integer age){
        if (age != null) {
            return userRepository.findByAge(age);
        }
        return null;
    }


}
