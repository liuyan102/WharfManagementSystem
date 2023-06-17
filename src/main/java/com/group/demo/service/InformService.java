package com.group.demo.service;

import com.github.pagehelper.PageInfo;
import com.group.demo.pojo.Contract;
import com.group.demo.pojo.Inform;
import com.group.demo.pojo.UnloadList;
import org.springframework.stereotype.Service;

import java.util.List;

public interface InformService {


    public List<Inform> queryAll();
    public int add(Inform inform);
    public Inform queryById(int InformID);
    public List<Inform> queryByKey(String key);
    public int delete(int InformID);
    public int update(Inform inform);

    PageInfo<Inform> getbypages(int pageNum, int pageSize);
}