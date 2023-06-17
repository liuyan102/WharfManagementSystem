package com.group.demo.controller;

import com.github.pagehelper.PageInfo;
import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.*;

import com.group.demo.result.ResultReturn;
import com.group.demo.service.ContractService;
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
import java.util.Map;


@Controller
public class ContractController {
    @Autowired
    ContractService contractService;

    @PostMapping("/ContracttoQueryAll")
    @ResponseBody
    public ResultReturn toQueryAll(){
        List<Contract> contractList =contractService.queryAll();
        if(contractList== null)
        {
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),contractList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),contractList);
        }
    }

    @GetMapping("/ContracttoQueryID")
    @ResponseBody
    public ResultReturn toQueryID(int contractID){
        System.out.println(contractID);
        Contract contract= contractService.queryById(contractID);
        if(contract == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),contract);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),contract);
        }
    }
    @GetMapping("queryContractByKey")
    @ResponseBody
    public ResultReturn queryContractByKey(String key){
        List<Contract> contractList = contractService.queryByKey(key);
        if(contractList == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),contractList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),contractList);
        }
    }

    @PostMapping("/ContracttoAdd")
    public ResultReturn toAdd(@RequestParam Map<String,Object> reqMap, Model model){
        Contract contract=new Contract();
        contract.setProjectName(reqMap.get("projectName").toString());
        contract.setPartA(reqMap.get("partA").toString());
        contract.setRepresentA(reqMap.get("representA").toString());
        contract.setPhoneA(reqMap.get("phoneA").toString());
        contract.setAddressA(reqMap.get("addressA").toString());
        contract.setPartB(reqMap.get("partB").toString());
        contract.setRepresentB(reqMap.get("representB").toString());
        contract.setPhoneB(reqMap.get("phoneB").toString());
        contract.setAddressB(reqMap.get("addressB").toString());
        contract.setLaw(reqMap.get("law").toString());
        contract.setContractContent(reqMap.get("contractContent").toString());
        contract.setSignDate(reqMap.get("signDate").toString());
        contract.setBeginDate(reqMap.get("beginDate").toString());
        contract.setEndDate(reqMap.get("endDate").toString());
        contract.setNotes(reqMap.get("notes").toString());
        System.out.println(contract);
        int add = contractService.add(contract);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),contract);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),contract);
        }
    }

    @PostMapping("/ContracttoDelete")
    @ResponseBody
    public ResultReturn toDelete(@RequestParam int ContractID) {
        int delete;
        delete = contractService.delete(ContractID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }

    }

    @PostMapping("/updatecontract")
    @ResponseBody
    public ResultReturn updatecontract(@RequestParam Map<String,Object> reqMap, Model model){
        Contract contract=new Contract();
        contract.setContractID(Integer.parseInt(reqMap.get("contractID").toString()));
        contract.setProjectName(reqMap.get("projectName").toString());
        contract.setPartA(reqMap.get("partA").toString());
        contract.setRepresentA(reqMap.get("representA").toString());
        contract.setPhoneA(reqMap.get("phoneA").toString());
        contract.setAddressA(reqMap.get("addressA").toString());
        contract.setPartB(reqMap.get("partB").toString());
        contract.setRepresentB(reqMap.get("representB").toString());
        contract.setPhoneB(reqMap.get("phoneB").toString());
        contract.setAddressB(reqMap.get("addressB").toString());
        contract.setLaw(reqMap.get("law").toString());
        contract.setContractContent(reqMap.get("contractContent").toString());
        contract.setSignDate(reqMap.get("signDate").toString());
        contract.setBeginDate(reqMap.get("beginDate").toString());
        contract.setEndDate(reqMap.get("endDate").toString());
        contract.setNotes(reqMap.get("notes").toString());
        int update = contractService.update(contract);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),contract);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),contract);
        }
    }
    @GetMapping("getcontractbypage")
    @ResponseBody
    public PageInfo<Contract> findByPage(int pageNum, int pageSize) {
        System.out.println(pageNum+"...."+pageSize);
        PageInfo<Contract> pageInfo = contractService.getbypages(pageNum, pageSize);
        return pageInfo;
    }
}
