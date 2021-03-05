package com.tuling.mybatis.dao;

import com.tuling.mybatis.pojo.Admin;

public interface AdminMapper {

    public Admin selectUser(Integer id);

    public Admin selectUser2(Integer id);

    public void updateAdmin(Admin admin);
}
