package com.crud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crud.bean.Employee;
import com.crud.bean.HardDiskMgt;
import com.crud.bean.Msg;
import com.crud.service.HardDiskMgtService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 处理员工信息CRUD请求
 *
 * @author copywang
 */
@Controller
public class HardDiskMgtController {

    @Autowired
    HardDiskMgtService hardDiskMgtService;

    /**
     * 导入jackson包 把对象转换成JSON字符串 第二稿 支持移动设备
     *
     * @param pn
     * @return
     */
    @RequestMapping("/hdm")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        // 引入PageHelper分页插件
        // 查询前调用，传入页码和记录数
        PageHelper.startPage(pn, 5);
        // startPage紧跟着的这个查询就是一个分页查询
        List<HardDiskMgt> emps = hardDiskMgtService.getAll();
        // PageInfo包装查询结果，封装了详细的分页信息和详细数据
        // 连续显示5页
        PageInfo pageInfo = new PageInfo(emps, 5);

        return Msg.success().add("pageInfo", pageInfo);
    }

    /**
     * 展示list.jsp页面 查询员工数据（分页查询） 第一稿 用静态方法刷新的页面，支持浏览器
     *
     * @return
     */
    // @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        // 引入PageHelper分页插件
        // 查询前调用，传入页码和记录数
        PageHelper.startPage(pn, 5);
        // startPage紧跟着的这个查询就是一个分页查询
        List<HardDiskMgt> emps = hardDiskMgtService.getAll();
        // PageInfo包装查询结果，封装了详细的分页信息和详细数据
        // 连续显示5页
        PageInfo pageInfo = new PageInfo(emps, 5);
        // 把PageInfo交给页面即可
        model.addAttribute("pageInfo", pageInfo);

        return "list";
    }

    @RequestMapping("hardDisk/send")
    public String hardDiskSendPage() {
        return "hardDiskMgt";
    }

    /**
     * 校验用户名是否被占用
     *
     * @param empName
     * @return
     */
  /*  @RequestMapping(value = "/checkuser", method = RequestMethod.POST)
    @ResponseBody
    public Msg checkuser(@RequestParam("empName") String empName) {
        // 判断用户名是否符合正则表达式

        String regex = "(^[A-Za-z0-9]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5}$)";
        if (!empName.matches(regex)) {
            // System.out.println(empName.matches(regex));
            return Msg.fail().add("va_msg", "名字必须是2-5个中文或者6-16位英文数字组合");
        }

        if (hardDiskMgtService.checkuser(empName)) {
            return Msg.success();
        } else {
            return Msg.fail().add("va_msg", "用户名不可用");
        }
    }

    */

    /**
     * 保存员工信息
     */
    @RequestMapping(value = "/hardDisk/sava", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveHd(@Valid HardDiskMgt hardDiskMgt, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            hardDiskMgtService.saveHd(hardDiskMgt);
            return Msg.success();
        }
    }

    /**
     * 批量删除硬盘记录
     * @param ids
     * @return
     */
    @RequestMapping(value = "/hardDiskDel/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] strIds = ids.split("-");

            // 一种实现
            /*for (String str : strIds) {
                hardDiskMgtService.deleteEmp(Integer.parseInt(str));
            }*/

            // 另一种实现
            List<Integer> del_ids = new ArrayList<Integer>();
            for (String str : strIds) {
                del_ids.add(Integer.parseInt(str));
            }
            hardDiskMgtService.deleteBatchEmp(del_ids);

        } else {
            hardDiskMgtService.deleteEmp(Integer.parseInt(ids));
        }
        return Msg.success();
    }


    /**
     *
     * 查询硬盘信息
     */

    @RequestMapping(value = "/hdm/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id) {
        HardDiskMgt hdm = hardDiskMgtService.getEmp(id);
        return Msg.success().add("hdm", hdm);
    }

    /**
     * 修改硬盘信息
     */
    @RequestMapping(value = "/hdm/{sendId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg getEmp(HardDiskMgt hardDiskMgt) {
        hardDiskMgtService.updateEmp(hardDiskMgt);
        return Msg.success();
    }

    /**
     * 查询员工信息
     *
     *//*
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id) {
        Employee emp = hardDiskMgtService.getEmp(id);
        return Msg.success().add("emp", emp);
    }

    *//**
     * 修改员工ID
     *//*
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg getEmp(Employee employee) {
        hardDiskMgtService.updateEmp(employee);
        return Msg.success();
    }
    *//*
     * //单个删除员工信息
     *
     * @RequestMapping(value="/emp/{id}",method=RequestMethod.DELETE)
     *
     * @ResponseBody public Msg deleteEmpById(@PathVariable("id")Integer id) {
     * hardDiskMgtService.deleteEmp(id); return Msg.success(); }
     *//*

     *//**
     * 批量删除员工信息:1-2-3 单个：1
     *//*
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("ids") String ids) {
        if (ids.contains("-")) {
            String[] strIds = ids.split("-");
            *//*
     * 一种实现 for (String str : strIds) {
     * hardDiskMgtService.deleteEmp(Integer.parseInt(str)); }
     *//*
            // 另一种实现
            List<Integer> del_ids = new ArrayList<Integer>();
            for (String str : strIds) {
                del_ids.add(Integer.parseInt(str));
            }
            hardDiskMgtService.deleteBatchEmp(del_ids);

        } else {
            hardDiskMgtService.deleteEmp(Integer.parseInt(ids));
        }
        return Msg.success();
    }

    @RequestMapping("/emp/query")
    public String toQueryPage() {
        return "query";
    }


    @RequestMapping("hardDisk/send")
    public String hardDiskSendPage() {
        return "hardDiskMgt";
    }
    *//**
     * 查询功能的查询员工信息 查询出来的员工数据分页显示
     *//*
    @RequestMapping(value = "/queryEmps", method = RequestMethod.POST)
    @ResponseBody
    public Msg queryEmp(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                        Employee employee) {
        // System.out.println(employee);
        PageHelper.startPage(pn, 20);
        List<Employee> emplist = hardDiskMgtService.queryEmp(employee);
        // PageInfo包装查询结果，封装了详细的分页信息和详细数据
        // 连续显示5页
        PageInfo pageInfo = new PageInfo(emplist, 5);
        return Msg.success().add("pageInfo", pageInfo);
    }

*/
}