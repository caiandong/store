package com.cy.store.service.impl;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * 用户模块业务层实现
 */
@Service // @Service 将当前类的对象交给Spring来管理，自动创建对象以及对象的维护
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        String username = user.getUsername();
        // 调用 findUsername(username)判断用户是否被注册过
        User result = userMapper.findByUsername(username);
        // 判断结果集是否不为null，被占用则抛出异常UsernameDuplicatedException
        if(result != null) {
            // 抛出异常
            throw new UsernameDuplicatedException("用户名被占用");
        }

        // 密码加密处理: md5算法形式
        // 串 + password + 串  ------md5算法进行加密
        String oldPassword = user.getPassword();
        // 获取一个盐值(随机生成一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        // 盐值保存
        user.setSalt(salt);
        // 将密码和盐值作为一个整体进行加密处理
        String md5Password = getMd5Password(oldPassword, salt);
        // 将加密之后的密码补全到 user 对象当中
        user.setPassword(md5Password);
        // 补全数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getCreatedUser());
        user.setModifiedUser(user.getModifiedUser());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        // 执行注册业务逻辑
        Integer rows = userMapper.insert(user);
        if(rows != 1) {
            throw new InsertException("用户在注册过程中产生了未知的异常");
        }
    }

    /**
     * 定义一个 md5 算法的加密处理
     */
    private String getMd5Password(String password, String salt) {
        // md5 加密算法的调用(进行3次加密)
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        // 返回加密之后的密码
        return password;
    }
}
