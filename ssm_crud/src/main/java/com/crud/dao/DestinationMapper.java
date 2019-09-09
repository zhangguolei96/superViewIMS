package com.crud.dao;

import com.crud.bean.Destination;

import java.util.List;

public interface DestinationMapper {
    List<Destination> selectByExample();
}
