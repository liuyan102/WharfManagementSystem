package com.group.demo.controller;

import com.github.pagehelper.PageInfo;
import com.group.demo.enums.ResultCode;
import com.group.demo.pojo.Ship;
import com.group.demo.pojo.UnloadList;
import com.group.demo.result.ResultReturn;
import com.group.demo.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ShipController {
    @Autowired
    ShipService shipService;

    @PostMapping("/addShip")
    @ResponseBody
    public ResultReturn addShip(@RequestParam Map<String,Object> reqMap, Model model){
        Ship ship =new Ship();
        ship.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
        ship.setPrincipalName(reqMap.get("principalName").toString());
        ship.setPrincipalPhone(reqMap.get("principalPhone").toString());
        ship.setCargoType(reqMap.get("cargoType").toString());
        ship.setEnterDate(reqMap.get("enterDate").toString());
        ship.setUnloadDate(reqMap.get("unloadDate").toString());
        ship.setCOC(reqMap.get("coc").toString());
        ship.setStatus(reqMap.get("status").toString());
        ship.setNotes(reqMap.get("notes").toString());
        int add = shipService.add(ship);
        if(add == 1){
            return ResultReturn.resultReturn(ResultCode.ADD_SUCCESS.getCode(),
                    ResultCode.ADD_SUCCESS.getMessage(),ship);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.ADD_FAILURE.getCode(),
                    ResultCode.ADD_FAILURE.getMessage(),ship);
        }

    }

    @PostMapping("/updateShip")
    @ResponseBody
    public ResultReturn updateShip(@RequestParam Map<String,Object> reqMap, Model model){
        Ship ship =new Ship();
        ship.setShipID(Integer.parseInt(reqMap.get("shipID").toString()));
        ship.setPortID(Integer.parseInt(reqMap.get("portID").toString()));
        ship.setPrincipalName(reqMap.get("principalName").toString());
        ship.setPrincipalPhone(reqMap.get("principalPhone").toString());
        ship.setCargoType(reqMap.get("cargoType").toString());
        ship.setEnterDate(reqMap.get("enterDate").toString());
        ship.setUnloadDate(reqMap.get("unloadDate").toString());
        ship.setCOC(reqMap.get("coc").toString());
        ship.setStatus(reqMap.get("status").toString());
        ship.setNotes(reqMap.get("notes").toString());
        int update = shipService.update(ship);
        if(update == 1){
            return ResultReturn.resultReturn(ResultCode.UPDATE_SUCCESS.getCode(),
                    ResultCode.UPDATE_SUCCESS.getMessage(),ship);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.UPDATE_FAILURE.getCode(),
                    ResultCode.UPDATE_FAILURE.getMessage(),ship);
        }
    }

    @GetMapping("/deleteShip")
    @ResponseBody
    public ResultReturn deleteShip(int shipID){
        int delete = shipService.delete(shipID);
        if(delete == 1){
            return ResultReturn.resultReturn(ResultCode.DELETE_SUCCESS.getCode(),
                    ResultCode.DELETE_SUCCESS.getMessage());
        }
        else {
            return ResultReturn.resultReturn(ResultCode.DELETE_FAILURE.getCode(),
                    ResultCode.DELETE_FAILURE.getMessage());
        }
    }

    @GetMapping("/getShipByID")
    @ResponseBody
    public ResultReturn getShipByID(int id){
        Ship ship = shipService.getByID(id);
        if(ship == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),ship);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),ship);
        }
    }

    @PostMapping("/getAllShip")
    @ResponseBody
    public ResultReturn getAllShip(){
        List<Ship> shipList = shipService.getAll();
        if(shipList == null){
            return ResultReturn.resultReturn(ResultCode.GET_FAILURE.getCode(),
                    ResultCode.GET_FAILURE.getMessage(),shipList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.GET_SUCCESS.getCode(),
                    ResultCode.GET_SUCCESS.getMessage(),shipList);
        }
    }

    @GetMapping("/queryShipByKey")
    @ResponseBody
    public ResultReturn queryShipByKey(String key){
        List<Ship> shipList = shipService.queryByKey(key);
        if(shipList == null){
            return ResultReturn.resultReturn(ResultCode.QUERY_FAILURE.getCode(),
                    ResultCode.QUERY_FAILURE.getMessage(),shipList);
        }
        else {
            return ResultReturn.resultReturn(ResultCode.QUERY_SUCCESS.getCode(),
                    ResultCode.QUERY_SUCCESS.getMessage(),shipList);
        }
    }

    @GetMapping("getshipbypage")
    @ResponseBody
    public PageInfo<Ship> findByPage(int pageNum, int pageSize) {
        System.out.println(pageNum+"...."+pageSize);
        PageInfo<Ship> pageInfo = shipService.getbypages(pageNum, pageSize);
        return pageInfo;
    }

}
