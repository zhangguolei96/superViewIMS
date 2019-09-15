package com.crud.service;

import java.util.List;

import com.crud.bean.HardDiskMgtExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.bean.Employee;
import com.crud.bean.HardDiskMgt;
import com.crud.bean.EmployeeExample;
import com.crud.bean.EmployeeExample.Criteria;
import com.crud.dao.EmployeeMapper;
import com.crud.dao.HardDiskMgtMapper;

@Service
public class HardDiskMgtService {
    @Autowired
    HardDiskMgtMapper hardDiskMgtMapper;

    EmployeeMapper employeeMapper;
    /**
     * 查询所有员工（分页查询）
     * @return
     */
    public List<HardDiskMgt> getAll() {
        return hardDiskMgtMapper.selectByExampleWithDent(null);
    }
    /**
     * 保存员工
     * @param employee
     */
    public void saveHd(HardDiskMgt hardDiskMgt) {
        hardDiskMgtMapper.insertSelective(hardDiskMgt);
    }
    /**
     * 校验用户名是否被占用
     * @param empName
     * @return
     */
    public boolean checkuser(String empName) {
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        return employeeMapper.countByExample(example) == 0;
    }
    /**
     * 修改员工信息的时候用于数据回显
     * @param id
     * @return
     */
    public HardDiskMgt getEmp(Integer id) {
        HardDiskMgt hardDiskMgt = hardDiskMgtMapper.selectByPrimaryKey(id);
        return hardDiskMgt;
    }
    /**
     * 修改员工信息的提交
     * @param id
     */
    public void updateEmp(HardDiskMgt hardDiskMgt) {
        hardDiskMgtMapper.updateByPrimaryKeySelective(hardDiskMgt);
    }
    /**
     * 删除员工信息
     * @param id
     */
    public void deleteEmp(Integer id) {
        hardDiskMgtMapper.deleteByPrimaryKey(id);
    }
    /**
     * 批量删除员工
     * @param ids
     */
    public void deleteBatchEmp(List<Integer> ids) {
        HardDiskMgtExample example = new HardDiskMgtExample();
        HardDiskMgtExample.Criteria criteria = example.createCriteria();
        criteria.andsendIdIn(ids);
        //delete from xxx where emp_id in (1,2,3);
        hardDiskMgtMapper.deleteByExample(example);
    }
    /**
     * 高级搜索功能
     * @param employee
     * @return
     */
    public List<Employee> queryEmp(Employee employee) {
        // TODO Auto-generated method stub
        EmployeeExample example = new EmployeeExample();
        Criteria criteria = example.createCriteria();
        System.out.println("".equals(employee.getEmpName()));
        if (!("".equals(employee.getEmpName()))) {
            criteria.andEmpNameEqualTo(employee.getEmpName());
        }
        if(!("".equals(employee.getEmail()))) {
            criteria.andEmailEqualTo(employee.getEmail());
        }
        criteria.andGenderEqualTo(employee.getGender());
        criteria.andDIdEqualTo(employee.getdId());

        return employeeMapper.selectByExampleWithDept(example);
    }
}
