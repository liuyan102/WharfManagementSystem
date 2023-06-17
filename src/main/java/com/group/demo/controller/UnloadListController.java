package com.group.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.Owner;
import com.group.demo.pojo.UnloadList;
import com.group.demo.result.ResultReturn;
import com.group.demo.service.UnloadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class UnloadListController {
    @Autowired
    UnloadListService unloadListService;

    /*@PostMapping("/addUnloadList")
    @ResponseBody
    public ResultReturn addUnloadList(@RequestBody UnloadList unloadList){
        int add = unloadListService.add(unloadList);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),unloadList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),unloadList);
        }
    }*/
    @PostMapping("/addUnloadList")
    @ResponseBody
    public ResultReturn addUnloadList(@RequestParam Map<String,Object> reqMap, Model model){
        UnloadList unloadList=new UnloadList();
        //unloadList.setUnloadListID(Integer.parseInt(reqMap.get("qd").toString()));
        //System.out.println(Integer.parseInt(reqMap.get("qd").toString()));
        unloadList.setOwnerID(Integer.parseInt(reqMap.get("ownID").toString()));
        unloadList.setShipID(Integer.parseInt(reqMap.get("cb").toString()));
        unloadList.setPortID(Integer.parseInt(reqMap.get("gk").toString()));
        unloadList.setUnloadDate(reqMap.get("date").toString());
        unloadList.setOwnerName(reqMap.get("name").toString());
        unloadList.setOwnerPhone(reqMap.get("dh").toString());
        unloadList.setCargoType(reqMap.get("lx").toString());
        unloadList.setCOC(reqMap.get("place").toString());
        unloadList.setNotes(reqMap.get("bz").toString());
        System.out.println(unloadList);
        int add = unloadListService.add(unloadList);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),unloadList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),unloadList);
        }
    }

    @PostMapping("/updateUnloadList")
    @ResponseBody
    public ResultReturn updateUnloadList(@RequestParam Map<String,Object> reqMap, Model model){
        UnloadList unloadList=new UnloadList();
        unloadList.setUnloadListID(Integer.parseInt(reqMap.get("qd").toString()));
        unloadList.setOwnerID(Integer.parseInt(reqMap.get("ownID").toString()));
        unloadList.setShipID(Integer.parseInt(reqMap.get("cb").toString()));
        unloadList.setPortID(Integer.parseInt(reqMap.get("gk").toString()));
        unloadList.setUnloadDate(reqMap.get("date").toString());
        unloadList.setOwnerName(reqMap.get("name").toString());
        unloadList.setOwnerPhone(reqMap.get("dh").toString());
        unloadList.setCargoType(reqMap.get("lx").toString());
        unloadList.setCOC(reqMap.get("place").toString());
        unloadList.setNotes(reqMap.get("bz").toString());
        System.out.println(unloadList);
        int update = unloadListService.update(unloadList);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),unloadList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),unloadList);
        }
    }

    @GetMapping("/deleteUnloadList")
    @ResponseBody
    public ResultReturn deleteUnloadList(int unloadListID){
        System.out.println(unloadListID);
        int delete = unloadListService.delete(unloadListID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }
    }

    @GetMapping("/getUnloadListByID")
    @ResponseBody
    public ResultReturn getUnloadListByID(int id){
        System.out.println("id==="+id);
        UnloadList unloadList = unloadListService.getByID(id);
        if(unloadList == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),unloadList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),unloadList);
        }
    }
    @GetMapping("queryUnloadListByKey")
    @ResponseBody
    public ResultReturn queryUnloadListByKey(String key){
        List<UnloadList> unloadLists = unloadListService.queryByKey(key);
        if(unloadLists == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),unloadLists);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),unloadLists);
        }
    }
    @PostMapping("/getUnloadListByOwnerID")
    @ResponseBody
    public ResultReturn getUnloadListByOwnerID(@RequestBody Owner owner){
        List<UnloadList> unloadLists = unloadListService.getByOwnerID(owner.getOwnerID());
        if(unloadLists == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),unloadLists);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),unloadLists);
        }
    }

    @PostMapping("/ownerQueryUnloadListByKey")
    @ResponseBody ResultReturn ownerQueryUnloadListByKey(@RequestBody String key,Owner owner){
        List<UnloadList> unloadLists = unloadListService.ownerQueryByKey(key,owner.getOwnerID());
        if(unloadLists == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),unloadLists);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),unloadLists);
        }
    }

    @PostMapping("getAllUnloadList")
    @ResponseBody
    public ResultReturn getAllUnloadList (){
        List<UnloadList> unloadLists = unloadListService.getAll();
        System.out.println(unloadLists);
        if(unloadLists == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),unloadLists);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),unloadLists);
        }
    }

    @GetMapping("getbypage")
    @ResponseBody
    public PageInfo<UnloadList> findByPage(int pageNum,int pageSize) {
        System.out.println(pageNum+"...."+pageSize);
        PageInfo<UnloadList> pageInfo = unloadListService.getbypages(pageNum, pageSize);
        return pageInfo;
    }

}
