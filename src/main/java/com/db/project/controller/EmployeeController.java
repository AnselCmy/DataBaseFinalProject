package com.db.project.controller;

import com.db.project.dao.*;
import com.db.project.entity.AttendLogEntity;
import com.db.project.entity.EmployeeEntity;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sun.security.krb5.internal.crypto.Aes128;

import javax.jws.WebParam;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @RequestMapping("/{ENo}")
    public String EmployeeDetail(@PathVariable String ENo, ModelMap model, HttpSession session) {
        EmployeeDao employeeDao = new EmployeeDao();
        AttendLogDao attendLogDao = new AttendLogDao();
        PayrollDao payrollDao = new PayrollDao();
        AttendEventDao attendEventDao = new AttendEventDao();
        SubsidyLogDao subsidyLogDao = new SubsidyLogDao();
        SubsidyEventDao subsidyEventDao = new SubsidyEventDao();
        // 从session获取当前登陆的currENo
        String currENo = String.valueOf(session.getAttribute("currENo"));
        // 当前登陆者的相关信息
        HashMap<String, String> currEmployee = employeeDao.getEntityWithMapByENo(currENo);
        // 当前被查询者的相关信息
        HashMap<String, String> searchEmployee = employeeDao.getEntityWithMapByENo(ENo);
        // 当前被查询者的考勤信息
        List<HashMap<String, String>> searchAttendLog = attendLogDao.getAttendLogWithMapByENo(ENo);
        // 当前被查询者的津贴信息
        List<HashMap<String, String>> searchSubsidyLog = subsidyLogDao.getSubsidyLogWithMapByENo(ENo);
        // 当前被查询者的工资信息
        List<HashMap<String, String>> searchPayroll = payrollDao.getPayrollWithMapByENo(ENo);
        // 考勤事件的详细信息
        List<HashMap<String, String>> allEvent = attendEventDao.getAllEventWithMap();
        // 考勤事件的详细信息
        List<HashMap<String, String>> allSubsidyEvent = subsidyEventDao.getAllEventWithMap();
        model.addAttribute("currEmployee", JSONArray.fromObject(currEmployee).toString());
        model.addAttribute("searchEmployee", JSONArray.fromObject(searchEmployee).toString());
        model.addAttribute("searchAttendLog", JSONArray.fromObject(searchAttendLog).toString());
        model.addAttribute("searchSubsidyLog", JSONArray.fromObject(searchSubsidyLog).toString());
        model.addAttribute("searchPayroll", JSONArray.fromObject(searchPayroll).toString());
        model.addAttribute("allEvent", JSONArray.fromObject(allEvent).toString());
        model.addAttribute("allSubsidyEvent", JSONArray.fromObject(allSubsidyEvent).toString());
        return "employee";
    }

    @RequestMapping(value = "/addattendlog", method = RequestMethod.POST)
    public String AddAttendLog(ModelMap model, HttpSession session,
                                @RequestParam(value = "AENo") String AENo,
                                @RequestParam(value = "ENo") String ENo) {
        AttendLogDao attendLogDao = new AttendLogDao();
        attendLogDao.addLog(ENo, AENo);
        return "redirect:/employee/"+ENo;
    }

    @RequestMapping("/deleteattendlog/{ENo}/{ALDate}/{AENo}")
    public String DeleteAttendLog(ModelMap model, HttpSession session,
                                    @PathVariable String ENo,
                                    @PathVariable String ALDate,
                                    @PathVariable String AENo) {
        AttendLogDao attendLogDao = new AttendLogDao();
        attendLogDao.deleteLog(ENo, ALDate, AENo);
        return "redirect:/employee/"+ENo;
    }

    @RequestMapping(value = "/addsubsidylog", method = RequestMethod.POST)
    @ResponseBody
    public String AddSubsidyLog(ModelMap model, HttpSession session,
                               @RequestParam(value = "ENo") String ENo,
                               @RequestParam(value = "SENo") String SENo,
                               @RequestParam(value = "SLMoney") String SLMoney,
                               @RequestParam(value = "SLComment") String SLComment) {
        return ENo+"/"+SENo+"/"+SLMoney+"/"+SLComment;
    }

    @RequestMapping("/deletesubsidylog/{ENo}/{SEDate}/{SENo}")
    @ResponseBody
    public String DeleteSubsidyLog(ModelMap model, HttpSession session,
                                  @PathVariable String ENo,
                                  @PathVariable String SEDate,
                                  @PathVariable String SENo) {
        return ENo+"/"+SENo+"/"+SEDate;
    }
}
