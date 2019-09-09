package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.bean.Department;
import com.crud.bean.Group;
import com.crud.dao.DepartmentMapper;
import com.crud.dao.GroupMapper;

@Service
public class GroupService {
    @Autowired
    private GroupMapper groupMapper;

    public List<Group> getGroups() {
        List<Group> list = groupMapper.selectByExample(null);
        return list;
    }
}
