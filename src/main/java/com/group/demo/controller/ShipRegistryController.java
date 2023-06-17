package com.group.demo.controller;

import com.github.pagehelper.PageInfo;
import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.Inform;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.ShipRegistry;

import com.group.demo.pojo.UnloadList;
import com.group.demo.result.ResultReturn;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.group.demo.service.ShipRegistryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
public class ShipRegistryController {

    @Autowired
    ShipRegistryService shipRegistryService;

    @PostMapping("/shippers")
    @ResponseBody
    public ShipRegistry shippers(@RequestBody ShipRegistry shipRegistry)
    {
        System.out.println(shipRegistry);

        return shipRegistry;
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello world!";
    }

    @PostMapping("/post_tests")
    @ResponseBody
    public String test_posts()
    {
        return "hello";
    }

    @PostMapping("/ShipRegtoQueryAll")
    @ResponseBody
    public ResultReturn toQueryAll()
    {
        List<ShipRegistry> shipRegistrylist=shipRegistryService.queryAll();
        System.out.println(shipRegistrylist);
        if(shipRegistrylist== null)
        {
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),shipRegistrylist);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),shipRegistrylist);
        }
    }

    @GetMapping("/ShipRegtoQueryID")
    @ResponseBody
    public ResultReturn toQueryID(int id){
        System.out.println("------------"+id);
        ShipRegistry shipRegistry = shipRegistryService.queryById(id);
        System.out.println("clsssssss"+shipRegistry);
        if(shipRegistry == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),shipRegistry);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),shipRegistry);
        }
    }
    @GetMapping("queryShipRegByKey")
    @ResponseBody
    public ResultReturn queryShipRegByKey(String key){
        List<ShipRegistry> shipRegistryList = shipRegistryService.queryByKey(key);
        if(shipRegistryList == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),shipRegistryList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),shipRegistryList);
        }
    }
    @PostMapping("/ShipRegtoAdd")
    @ResponseBody
    public ResultReturn toAdd(@RequestParam Map<String,Object> reqMap, Model model){
       ShipRegistry shipRegistry =new ShipRegistry();
       shipRegistry.setRegistrationDate(reqMap.get("registrationDate").toString());
       shipRegistry.setShipID(Integer.parseInt(reqMap.get("shipID").toString()));
       shipRegistry.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
       shipRegistry.setTCNum(reqMap.get("tcNum").toString());
       shipRegistry.setTCValidity(reqMap.get("tcValidity").toString());
       shipRegistry.setShipType(reqMap.get("shipType").toString());
       shipRegistry.setCargoWeight(Integer.parseInt(reqMap.get("cargoWeight").toString()));
       shipRegistry.setPrincipalName(reqMap.get("principalName").toString());
       shipRegistry.setPrincipalPhone(reqMap.get("principalPhone").toString());
       shipRegistry.setAdminName(reqMap.get("adminName").toString());
       shipRegistry.setAdminPhone(reqMap.get("adminPhone").toString());
       shipRegistry.setNotes(reqMap.get("notes").toString());
        int add = shipRegistryService.add(shipRegistry);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),shipRegistry);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),shipRegistry);
        }
    }

    @PostMapping("/ShipRegtoDelete")
    @ResponseBody
    public ResultReturn toDelete(@RequestParam int ShipRegistrationID) {

        int delete;
        delete = shipRegistryService.delete(ShipRegistrationID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }

    }

    @PostMapping("/updateshipRegistry")
    @ResponseBody
    public ResultReturn updateshipRegistry(@RequestParam Map<String,Object> reqMap, Model model){
        ShipRegistry shipRegistry =new ShipRegistry();
        shipRegistry.setShipRegistrationID(Integer.parseInt(reqMap.get("shipRegistrationID").toString()));
        shipRegistry.setRegistrationDate(reqMap.get("registrationDate").toString());
        shipRegistry.setShipID(Integer.parseInt(reqMap.get("shipID").toString()));
        shipRegistry.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
        shipRegistry.setTCNum(reqMap.get("tcNum").toString());
        shipRegistry.setTCValidity(reqMap.get("tcValidity").toString());
        shipRegistry.setShipType(reqMap.get("shipType").toString());
        shipRegistry.setCargoWeight(Integer.parseInt(reqMap.get("cargoWeight").toString()));
        shipRegistry.setPrincipalName(reqMap.get("principalName").toString());
        shipRegistry.setPrincipalPhone(reqMap.get("principalPhone").toString());
        shipRegistry.setAdminName(reqMap.get("adminName").toString());
        shipRegistry.setAdminPhone(reqMap.get("adminPhone").toString());
        shipRegistry.setNotes(reqMap.get("notes").toString());
        int update = shipRegistryService.update(shipRegistry);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),shipRegistry);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),shipRegistry);
        }
    }
    @GetMapping("getshipregbypage")
    @ResponseBody
    public PageInfo<ShipRegistry> findByPage(int pageNum, int pageSize) {
        System.out.println(pageNum+"...."+pageSize);
        PageInfo<ShipRegistry> pageInfo = shipRegistryService.getbypages(pageNum, pageSize);
        return pageInfo;
    }
}
