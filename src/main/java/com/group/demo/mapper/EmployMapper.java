package com.group.demo.mapper;

import com.group.demo.pojo.Employ;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployMapper {
    int add(Employ employ);
    Employ queryByUsername(String username);
    Employ queryByID(int id);
    List<Employ> queryAll();
    int updateEmploy(Employ employ);
    int updatePassword(Employ employ);
    int deleteEmploy(int id);

}
