package com.tuling.mybatis.dao;

import com.tuling.mybatis.pojo.Admin;
import org.apache.ibatis.annotations.Select;

public interface AdminMapper3 {

    @Select("select * from admin where eid=#{eid}")
    Admin selectById(Integer eid);



}
