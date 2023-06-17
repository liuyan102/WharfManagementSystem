package com.group.demo.service;

import com.github.pagehelper.PageInfo;
import com.group.demo.pojo.ShipRegistry;
import com.group.demo.pojo.UnloadList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShipRegistryService {

    public List<ShipRegistry> queryAll();
    public int add(ShipRegistry shipRegistry);
    public ShipRegistry queryById(int ShipregID);
    public List<ShipRegistry> queryByKey(String key);
    public int delete(int ShipregID);
    public int update(ShipRegistry shipRegistry);
    PageInfo<ShipRegistry> getbypages(int pageNum, int pageSize);
}