package com.db.project.controller;


import com.db.project.dao.EmployeeDao;
import com.db.project.dao.UserDao;
import com.db.project.entity.EmployeeEntity;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {
    @RequestMapping("")
    public String MainHome(HttpSession session, ModelMap model) {
        // 判断是否存在session
        String currENo = String.valueOf(session.getAttribute("currENo"));
        UserDao userDao = new UserDao();
        if(currENo.equals("null")) {
            return "redirect:/login/submit/normal";
        }
        else {
            EmployeeDao employeeDao = new EmployeeDao();
            EmployeeEntity currEmployee = employeeDao.getEntityByENo(currENo);
            List<ArrayList<String>> allEmployee = employeeDao.getAllEntityWithList();
            model.addAttribute("currENo", currENo);
            model.addAttribute("currEName", currEmployee.geteName());
            model.addAttribute("allEntity", JSONArray.fromObject(allEmployee).toString());
            // 根据用户的权限的不同有不同的页面
            String level = userDao.getLevelByENo(currENo);
            if(level.equals("1")) {
                return "index";
            }
            return "normal_main";
        }
    }
}
