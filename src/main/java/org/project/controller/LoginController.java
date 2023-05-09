package org.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author jackqiu
 */
//用于登录的控制器类
@Controller
public class LoginController {

    @RequestMapping("/user/login")
    public String loginCheck(@RequestParam("username") String username,
                             @RequestParam("password") String password,
                             HttpSession session,
                             Model model){
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("LoginUser",username);
            return "redirect:/main.html";//与视图解析器结合-->"redirect:/main.html"为重定向访问/main.html
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }

    @RequestMapping("/user/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        //pull远程库
        //转发操作
        return "redirect:/index.html";
    }

    /*@RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>springBoot<h1>");
        model.addAttribute("users", Arrays.asList("Application","Initializing"));
        return "test";
    }*/
}
