package com.group.demo.service;

import com.github.pagehelper.PageInfo;
import com.group.demo.pojo.Contract;
import com.group.demo.pojo.UnloadList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ContractService {


    public List<Contract> queryAll();
    public int add(Contract delegation);
    public Contract queryById(int ContractID);
    public List<Contract> queryByKey(String key);
    public int delete(int ContractID);
    public  int update(Contract contract);
    PageInfo<Contract> getbypages(int pageNum, int pageSize);
}