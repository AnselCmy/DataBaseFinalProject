package com.db.project.controller;

import javax.servlet.http.HttpSession;

import com.db.project.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.db.project.dao.UserDao;


@Controller
@RequestMapping("/login")
public class LoginController {
    /*
    登陆的主要页面，其中state表明的是第一次输入还是输入错误后重定位的
     */
    @RequestMapping("/submit/{state}")
    public String LoginSubmit(@PathVariable String state, ModelMap model) {
        if(!state.equals("redirect")) {
            state = "normal";
        }
        model.addAttribute("state", state);
        return "login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public String LoginCheck(@RequestParam(value = "id") String id,
                                @RequestParam(value = "password") String password,
                                HttpSession session) {
        UserDao userDao = new UserDao();
        UserEntity userEntity = userDao.CheckUser(id, password);
        // 如果是合法用户则建立相应的session
        if(userEntity != null) {
            session.setAttribute("currENo", userEntity.geteNo());
            return "redirect:/main";
        }
        // 如果输入不正确或者不合法则重定位到submit
        else {
            return "redirect:/login/submit/redirect";
        }
    }
}
