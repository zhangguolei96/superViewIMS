package com.crud.dao;

import com.crud.bean.HardDiskMgt;
import com.crud.bean.EmployeeExample;
import com.crud.bean.HardDiskMgtExample;

import java.util.List;

public interface HardDiskMgtMapper {
    //新增加的2个方法，用于查询员工的时候根据员工的d_id查询显示出部门名称
    List<HardDiskMgt> selectByExampleWithDent(HardDiskMgtExample example);

    // 插入一条硬盘新纪录
    int insertSelective(HardDiskMgt record);

    // 删除单条记录
    int deleteByPrimaryKey(Integer sendId);
    // 删除多条记录
    int deleteByExample(HardDiskMgtExample example);
}
