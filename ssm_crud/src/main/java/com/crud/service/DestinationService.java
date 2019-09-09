package com.crud.service;


import com.crud.bean.Destination;
import com.crud.dao.DestinationMapper;
import com.crud.dao.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {
    @Autowired
    private DestinationMapper destinationMapper;

    public List<Destination> getDesn() {
        List<Destination> list = destinationMapper.selectByExample();
        return list;
    }
}
