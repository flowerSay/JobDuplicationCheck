package com.recheck.mapper;

import com.recheck.entity.People;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PeopleMapper {
    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    People getPeopleByUserName(String username);

    /**
     * 根据用户id查询其用户角色
     * @param userId
     * @return
     */
    List<String> selectAllRolesByUserId(Integer userId);

    /**
     * 根据用户id查询权限
     * @param userId
     * @return
     */
    List<String> selectPermissionsByUserId(Integer userId);

    /**
     * 添加用户
     */
    void addPeople(People people);
}
