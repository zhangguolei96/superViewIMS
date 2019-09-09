package com.crud.controller;


import com.crud.bean.Destination;
import com.crud.bean.Msg;
import com.crud.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DestinationController {
    @Autowired
    private DestinationService destinationService;
    /**
     * 返回所有的组别信息
     * 返回JSON
     */
    @RequestMapping("/destination")
    @ResponseBody
    public Msg getGroups() {
        List<Destination> list = destinationService.getDesn();
        return Msg.success().add("destinations", list);
    }
}
