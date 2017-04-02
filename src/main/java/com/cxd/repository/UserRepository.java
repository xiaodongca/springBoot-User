package com.cxd.repository;

import com.cxd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by cai x d
 * on2017/4/2 0002.
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    //通过年龄来查询
    public List<User> findByAge(Integer age);
}
