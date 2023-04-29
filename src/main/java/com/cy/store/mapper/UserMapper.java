package com.cy.store.mapper;

import com.cy.store.entity.User;

/**
 * 用户模块的持久层接口
 */
//@Mapper
public interface UserMapper {
    /**
     * 插入用户的数据
     * @param user 插入的用户数据
     * @return 受影响的行数（增、删、改，受影响的行数返回作为值，可以根据返回值来判断是否执行成功）
     */
    Integer insert(User user);

    /**
     * 根据用户名来查询用户的数据
     * @param username 用户名
     * @return 如果找到对应的用户名返回这个用户的数据，没有返回为null
     */
    User findByUsername(String username);
}
