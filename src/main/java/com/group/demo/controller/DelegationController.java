package com.group.demo.controller;

import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.*;

import com.group.demo.result.ResultReturn;
import com.group.demo.service.DelegationService;
import com.group.demo.service.InformService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.group.demo.service.ShipRegistryService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class DelegationController {
    @Autowired
    DelegationService delegationService;

    @PostMapping("/DelegationQueryAll")
    public String toQueryAll(){
        List<Delegation> delegationlist;
        delegationlist=delegationService.queryAll();
        if(delegationlist!= null)
        {

            return "success";
        }
        else
        {

            return "fail";
        }
    }

    @GetMapping("/DelegationtoQueryID")
    @ResponseBody
    public ResultReturn toQueryID(int DelegationID){
        Delegation delegation= delegationService.queryById(DelegationID);
        if(delegation == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),delegation);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),delegation);
        }
    }

    @PostMapping("/DelegationtoAdd")
    public String toAdd(@RequestBody Delegation delegation){
        int a;
        a=delegationService.add(delegation);
        if(a>0)
        {

            return "success";
        }
        else
        {

            return "fail";
        }

    }

    @PostMapping("/DelegationtoDelete")
    public ResultReturn toDelete(@RequestParam int DelegationID) {
        int delete;
        delete = delegationService.delete(DelegationID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }
    }

    @PostMapping("/updatedelegation")
    @ResponseBody
    public ResultReturn updatedelegation(@RequestBody Delegation delegation){
        int update = delegationService.update(delegation);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),delegation);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),delegation);
        }
    }
}
