package com.cy.store.controller;

import com.cy.store.entity.User;
import com.cy.store.service.IUserService;
import com.cy.store.service.ex.InsertException;
import com.cy.store.service.ex.UsernameDuplicatedException;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController // 作用相当于 @Controller +  @ResponseBody
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    //  @ResponseBody // 表示此方法的响应结果以 json 格式进行数据的相应给到前端
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<>(OK);
    }

//    @RequestMapping("reg")
//    //  @ResponseBody // 表示此方法的响应结果以 json 格式进行数据的相应给到前端
//    public JsonResult<Void> reg(User user) {
//        // 创建响应结果对象
//        JsonResult<Void> result = new JsonResult<>();
//        try {
//            userService.reg(user);
//            result.setState(200);
//            result.setMessage("用户注册成功");
//        } catch (UsernameDuplicatedException e) {
//            result.setState(4000);
//            result.setMessage("用户名被占用");
//        } catch (InsertException e) {
//            result.setState(5000);
//            result.setMessage("注册时产生未知异常");
//        }
//        return result;
//    }
}
