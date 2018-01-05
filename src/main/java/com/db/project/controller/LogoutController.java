package com.db.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @RequestMapping("")
    public String Logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login/submit/normal";
    }
}
