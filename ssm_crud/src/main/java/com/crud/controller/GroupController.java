package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.bean.Department;
import com.crud.bean.Group;
import com.crud.bean.Employee;
import com.crud.bean.Msg;
import com.crud.service.DepartmentService;
import com.crud.service.GroupService;
import com.crud.service.EmployeeService;


/*处理和组别有关的请求*/
@Controller
public class GroupController {
    @Autowired
    private GroupService groupService;
    /**
     * 返回所有的组别信息
     * 返回JSON
     */
    @RequestMapping("/groups")
    @ResponseBody
    public Msg getGroups() {
        List<Group> list = groupService.getGroups();
        return Msg.success().add("groups", list);
    }
}
