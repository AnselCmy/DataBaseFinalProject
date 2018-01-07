package com.db.project.controller;

import com.db.project.dao.*;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/setting")
public class SettingController {
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public String NewPassword(@RequestParam(value = "password") String password,
                              @RequestParam(value = "rpassword") String rpassword,
                              @RequestParam(value = "ENo") String ENo,
                              ModelMap model, HttpSession session) {
        if(password.equals(rpassword)) {
            UserDao userDao = new UserDao();
            EmployeeDao employeeDao = new EmployeeDao();
            // 从session获取当前登陆的currENo
            String currENo = String.valueOf(session.getAttribute("currENo"));
            // 当前登陆者的相关信息
            HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
            model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
            userDao.setNewPassword(ENo, password);
            return "redirect:/main";
        }
        else {
            return "setting";
        }
    }
}
