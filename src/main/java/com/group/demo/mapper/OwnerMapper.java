package com.group.demo.mapper;

import com.group.demo.pojo.Owner;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OwnerMapper {
    int add(Owner owner);
    Owner queryByUsername(String username);
    Owner queryByID(int id);
    List<Owner> queryAll();
    int updateOwner(Owner owner);
    int updatePassword(Owner owner);
    int deleteOwner(int id);
}
