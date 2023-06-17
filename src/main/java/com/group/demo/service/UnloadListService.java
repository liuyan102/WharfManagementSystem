package com.group.demo.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.group.demo.pojo.Inform;
import com.group.demo.pojo.UnloadList;

import java.util.List;

public interface UnloadListService {
    //新建卸货清单
    int add(UnloadList unloadList);
    //编辑卸货清单
    int update(UnloadList unloadList);
    //删除卸货清单
    int delete(int id);
    //查看卸货清单
    UnloadList getByID(int id);
    //货主获取卸货清单
    List<UnloadList> getByOwnerID(int id);
    //货主查询卸货清单
    List<UnloadList> ownerQueryByKey(String key, int id);
    //员工获取卸货清单
    List<UnloadList> getAll();
    //员工查询卸货清单
    List<UnloadList> queryByKey(String key);
    PageInfo<UnloadList> getbypages(int pageNum, int pageSize);
}
