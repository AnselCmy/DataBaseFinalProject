package com.db.project.controller;


import com.db.project.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("")
    public String MainHome(HttpSession session, ModelMap model) {
        String currUserId = String.valueOf(session.getAttribute("currUserId"));
        UserDao userDao = new UserDao();
        if(currUserId.equals("null")) {
            return "redirect:/login/submit/normal";
        }
        else {
            // 根据用户的权限的不同有不同的页面
            model.addAttribute("currUserId", currUserId);
            String level = userDao.getLevelByENo(currUserId);
            if(level.equals("1")) {
                return "root_main";
            }
            return "normal_main";
        }
    }
}
