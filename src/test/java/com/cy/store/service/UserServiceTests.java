package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @SpringBootTest 表示标注当前的类是一个测试类，不会随同项目一起打包发送
@SpringBootTest
// @RunWith 启动这个单元测试类（单元测试类是不能运行的）,需要传递一个参数，必须是 SpringRunner 的实例类型
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    public void reg() {
        try {
//            User user = new User();
//            user.setUsername("搬搬");
//            user.setPassword("123");
//            userService.reg(user);
//            System.out.println("OK");
        } catch(ServiceException e) {
//            // 获取类的对象 获取类的名称
//            System.out.println(e.getClass().getSimpleName());
//            // 获取异常的具体描述信息ß
//            System.out.println(e.getMessage());
        }
    }
}
