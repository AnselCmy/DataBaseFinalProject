package com.db.project.controller;


import com.db.project.dao.StudentDao;
import com.db.project.entity.StudentEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")//Contoller下所有接口统一入口
public class StudentController {
    //映射一个action
    @RequestMapping("/user")
    @ResponseBody//表示直接输出返回内容，不进行jsp或html跳转，本例是为了写接口，这里直接返回json
    public List<StudentEntity> getUser() {
        StudentDao dao = new StudentDao();
        //查询stage表的所有数据，返回json
        return dao.query();
    }
}

