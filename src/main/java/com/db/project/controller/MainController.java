package com.db.project.controller;


import com.db.project.dao.EmployeeDao;
import com.db.project.dao.UserDao;
import com.db.project.entity.EmployeeEntity;
import com.db.project.dao.*;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
            DepartmentDao departmentDao = new DepartmentDao();
            EmployeeDao employeeDao = new EmployeeDao();
            AttendLogDao attendLogDao = new AttendLogDao();
            PayrollDao payrollDao = new PayrollDao();
            AttendEventDao attendEventDao = new AttendEventDao();
            SubsidyLogDao subsidyLogDao = new SubsidyLogDao();
            HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
            model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
            // 根据用户的权限的不同有不同的页面
            String level = userDao.getLevelByENo(currENo);
            if(level.equals("1")) {
                List<HashMap<String, String>> allDepartment = departmentDao.getAllDepartmentWithMap();
                List<HashMap<String, String>> allEmployee = employeeDao.getAllEntityWithMap();
                model.addAttribute("allDepartment", JSONArray.fromObject(allDepartment).toString());
                model.addAttribute("allEmployee", JSONArray.fromObject(allEmployee).toString());
                return "root_mng_board";
            }
            else {
//                // 当前被查询者的相关信息
//                HashMap<String, String> searchEmployee = employeeDao.getEntityWithMapByENo(currENo);
//                // 当前被查询者的考勤信息
//                List<HashMap<String, String>> searchAttendLog = attendLogDao.getAttendLogWithMapByENo(currENo);
//                // 当前被查询者的工资信息
//                List<HashMap<String, String>> searchPayroll = payrollDao.getPayrollWithMapByENo(currENo);
//                // 考勤事件的详细信息
//                List<HashMap<String, String>> allEvent = attendEventDao.getAllEventWithMap();
//                // 当前登陆者的津贴信息
//                List<HashMap<String, String>> searchSubsidyLog = subsidyLogDao.getSubsidyLogWithMapByENo(currENo);
//                model.addAttribute("searchAttendLog", JSONArray.fromObject(searchAttendLog).toString());
//                model.addAttribute("searchSubsidyLog", JSONArray.fromObject(searchSubsidyLog).toString());
//                model.addAttribute("searchPayroll", JSONArray.fromObject(searchPayroll).toString());
//                return "normal_idv_board";
                return "redirect:/main/idv";
            }
        }
    }

    @RequestMapping("/dep")
    public String Statistic(ModelMap model, HttpSession session) {
        String currENo = String.valueOf(session.getAttribute("currENo"));
        DataAnalysis dataAnalysis = new DataAnalysis();
        EmployeeDao employeeDao = new EmployeeDao();
        HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
        List<HashMap<String, String>> depDataByYear = dataAnalysis.CountPayrollByYear();
        HashMap<String, List<HashMap<String, String>>> depDataByMonth = dataAnalysis.CountPayrollByMonth();
        model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
        model.addAttribute("depDataByYear", JSONArray.fromObject(depDataByYear).toString());
        model.addAttribute("depDataByMonth", JSONArray.fromObject(depDataByMonth).toString());
        return "root_dep_board";
    }

    @RequestMapping("/idv")
    public String Individual(HttpSession session, ModelMap model) {
        // 判断是否存在session
        String currENo = String.valueOf(session.getAttribute("currENo"));
        // 判断是否存在session
        if(currENo.equals("null")) {
            return "redirect:/login/submit/normal";
        }
        // dao初始化
        EmployeeDao employeeDao = new EmployeeDao();
        AttendLogDao attendLogDao = new AttendLogDao();
        PayrollDao payrollDao = new PayrollDao();
        UserDao userDao = new UserDao();
        SubsidyLogDao subsidyLogDao = new SubsidyLogDao();
        // 获取当前登陆者的信息
        HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
        // 当前登陆者的考勤信息
        List<HashMap<String, String>> searchAttendLog = attendLogDao.getAttendLogWithMapByENo(currENo);
        // 当前登陆者的工资信息
        List<HashMap<String, String>> searchPayroll = payrollDao.getPayrollWithMapByENo(currENo);
        // 当前登陆者的津贴信息
        List<HashMap<String, String>> searchSubsidyLog = subsidyLogDao.getSubsidyLogWithMapByENo(currENo);
        model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
        model.addAttribute("searchAttendLog", JSONArray.fromObject(searchAttendLog).toString());
        model.addAttribute("searchSubsidyLog", JSONArray.fromObject(searchSubsidyLog).toString());
        model.addAttribute("searchPayroll", JSONArray.fromObject(searchPayroll).toString());
        // 根据用户的权限的不同有不同的页面
        String level = userDao.getLevelByENo(currENo);
        if(level.equals("1")) {
            return "root_idv_board";
        }
        else {
            return "normal_idv_board";
        }
    }

    @RequestMapping("/search")
    public String Search(ModelMap model, HttpSession session) {
        String currENo = String.valueOf(session.getAttribute("currENo"));
        EmployeeDao employeeDao = new EmployeeDao();
        DepartmentDao departmentDao = new DepartmentDao();
        List<HashMap<String, String>> allDepartment = departmentDao.getAllDepartmentWithMap();
        List<HashMap<String, String>> allEmployee = employeeDao.getAllEntityWithMap();
        HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
        model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
        model.addAttribute("allEmployee", JSONArray.fromObject(allEmployee).toString());
        model.addAttribute("allDepartment", JSONArray.fromObject(allDepartment).toString());
        return "root_search_board";
    }
}
