package com.group.demo.mapper;

import com.github.pagehelper.Page;
import com.group.demo.pojo.UnloadList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UnloadListMapper {
    int add(UnloadList unloadList);
    UnloadList queryByUnloadListID(int id);
    List<UnloadList> queryByOwnerID(int id);
    List<UnloadList> ownerQueryByKey(String key, int id);
    List<UnloadList> queryAll();
    List<UnloadList> queryByKey(String key);
    int update(UnloadList unloadList);
    int delete(int UnloadListID);
    List<UnloadList> getbypages();
}
