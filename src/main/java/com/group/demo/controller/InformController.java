package com.group.demo.controller;

import com.github.pagehelper.PageInfo;
import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.*;

import com.group.demo.result.ResultReturn;
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
public class InformController {
    @Autowired
    InformService informService;

    @PostMapping("/InformtoQueryAll")
    @ResponseBody
    public ResultReturn toQueryAll(){
        List<Inform> informlist =informService.queryAll();
        if(informlist== null)
        {
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),informlist);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),informlist);
        }
    }





    @GetMapping("/InformtoQueryID")
    @ResponseBody
    public ResultReturn toQueryID(int id){
        Inform inform= informService.queryById(id);
        if(inform == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),inform);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),inform);
        }
    }
    @GetMapping("queryInformByKey")
    @ResponseBody
    public ResultReturn queryInformByKey(String key){
        List<Inform> informList = informService.queryByKey(key);
        if(informList == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),informList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),informList);
        }
    }
    @PostMapping("/InformtoAdd")
    @ResponseBody
    public ResultReturn toAdd(@RequestParam Map<String,Object> reqMap, Model model){
        Inform inform = new Inform();
        inform.setInformDate(reqMap.get("informDate").toString());
        inform.setShipID(Integer.parseInt(reqMap.get("shipID").toString()));
        inform.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
        inform.setOwnerName(reqMap.get("ownerName").toString());
        inform.setOwnerPhone(reqMap.get("ownerPhone").toString());
        inform.setCargoType(reqMap.get("cargoType").toString());
        inform.setCargoWeight(Integer.parseInt(reqMap.get("cargoWeight").toString()));
        inform.setUnloadDate(reqMap.get("unloadDate").toString());
        inform.setNotes(reqMap.get("notes").toString());
        System.out.println(inform);
        int add = informService.add(inform);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),inform);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),inform);
        }
    }

    @PostMapping("/InformtoDelete")
    @ResponseBody
    public ResultReturn toDelete(@RequestBody int InformID) {
        int delete;
        delete = informService.delete(InformID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }

    }

    @PostMapping("/updateInform")
    @ResponseBody
    public ResultReturn updateinform(@RequestParam Map<String,Object> reqMap, Model model){
        Inform inform = new Inform();
        inform.setInformID(Integer.parseInt(reqMap.get("informID").toString()));
        inform.setInformDate(reqMap.get("informDate").toString());
        inform.setShipID(Integer.parseInt(reqMap.get("shipID").toString()));
        inform.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
        inform.setOwnerName(reqMap.get("ownerName").toString());
        inform.setOwnerPhone(reqMap.get("ownerPhone").toString());
        inform.setCargoType(reqMap.get("cargoType").toString());
        inform.setCargoWeight(Integer.parseInt(reqMap.get("cargoWeight").toString()));
        inform.setUnloadDate(reqMap.get("unloadDate").toString());
        inform.setNotes(reqMap.get("notes").toString());
        System.out.println(inform);
        int update = informService.update(inform);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),inform);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),inform);
        }
    }
    @GetMapping("getinformbypage")
    @ResponseBody
    public PageInfo<Inform> findByPage(int pageNum, int pageSize) {
        System.out.println(pageNum+"...."+pageSize);
        PageInfo<Inform> pageInfo = informService.getbypages(pageNum, pageSize);
        return pageInfo;
    }
}
