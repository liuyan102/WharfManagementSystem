package com.group.demo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.group.demo.mapper.UnloadListMapper;
import com.group.demo.pojo.UnloadList;
import com.group.demo.service.UnloadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnloadListServiceImpl implements UnloadListService {
    @Autowired
    UnloadListMapper unloadListMapper;

    @Override //新建卸货清单
    public int add(UnloadList unloadList){
        int add = unloadListMapper.add(unloadList);
        if(add > 0){ //新建成功
            return 1;
        }
        else { //新建失败
            return 0;
        }
    }

    @Override
    public PageInfo<UnloadList> getbypages(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UnloadList> unloadListList =  unloadListMapper.getbypages();
        return new PageInfo<>(unloadListList);
    }

    @Override //编辑卸货清单
    public int update(UnloadList unloadList){
        int update = unloadListMapper.update(unloadList);
        if(update >= 0){ //编辑成功
            return 1;
        }
        else { //编辑失败
            return 0;
        }
    }

    @Override //删除卸货清单
    public int delete(int id){
        int delete = unloadListMapper.delete(id);
        if(delete > 0){ //删除成功
            return 1;
        }
        else { //删除失败
            return 0;
        }
    }

    @Override //查看卸货清单
    public UnloadList getByID(int id){
        UnloadList unloadList = unloadListMapper.queryByUnloadListID(id);
        if(unloadList != null){ //查看成功
            return unloadList;
        }
        else { //查看失败
            return null;
        }
    }

    @Override //货主获取卸货清单
    public List<UnloadList> getByOwnerID(int id){
        List<UnloadList> unloadLists = null;
        unloadLists = unloadListMapper.queryByOwnerID(id);
        if(unloadLists != null){ //获取不为空
            return unloadLists;
        }
        else{ //获取为空
            return null;
        }
    }

    @Override //货主查询卸货清单
    public List<UnloadList> ownerQueryByKey(String key,int id){
        List<UnloadList> unloadLists = null;
        unloadLists = unloadListMapper.ownerQueryByKey(key,id);
        if(unloadLists != null){ //查询不为空
            return unloadLists;
        }
        else { //查询为空
            return null;
        }
    }

    @Override //员工获取卸货清单
    public List<UnloadList> getAll(){
        List<UnloadList> unloadLists = null;
        unloadLists = unloadListMapper.queryAll();
        if(unloadLists != null){ //获取不为空
            return unloadLists;
        }
        else { //获取为空
            return  null;
        }
    }

    @Override //员工查询卸货清单
    public List<UnloadList> queryByKey(String key){
        List<UnloadList> unloadLists = null;
        unloadLists = unloadListMapper.queryByKey(key);
        if(unloadLists != null){ //查询不为空
            return unloadLists;
        }
        else { //查询为空
            return null;
        }
    }
}
