package com.tuling.mybatis;


import java.io.IOException;
import java.io.InputStream;

import com.tuling.mybatis.dao.AdminMapper;
import com.tuling.mybatis.dao.AdminMapper2;
import com.tuling.mybatis.dao.AdminMapper3;
import com.tuling.mybatis.pojo.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class Demo {

    private SqlSession session;
    private SqlSessionFactory factory;

    @Before
    public void init() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config2.xml");
        //2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者创建工厂对象
        factory = builder.build(in);
        //4.使用SqlSessionFactory生产SqlSession对象
        session = factory.openSession(true);
    }

    @Test
    public void test0() throws IOException {

        //5.使用SqlSession创建dao接口的代理对象
        AdminMapper userDao = session.getMapper(AdminMapper.class);
        //6.使用代理对象执行查询所有方法
        Admin user = userDao.selectUser(1);
        System.out.println(user);
    }

    @Test
    public void testCache() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);

        Admin admin = mapper.selectUser(1);

        // 清空缓存
        // session.clearCache();
        mapper.updateAdmin(new Admin(1, "234", "234"));

        Admin admin1 = mapper.selectUser(1);
        System.out.println(admin == admin1);
    }

    @Test
    public void testCache2() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        AdminMapper2 mapper2 = session.getMapper(AdminMapper2.class);

        Admin admin = mapper.selectUser(1);

        Admin admin1 = mapper2.selectUser(1);

        System.out.println(admin == admin1);
    }

    @Test
    public void testCache3() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        Admin admin = mapper.selectUser(1);

        Admin admin1 = mapper.selectUser2(1);
        System.out.println(admin == admin1);
    }

    @Test
    public void testCache4() {
        AdminMapper mapper = session.getMapper(AdminMapper.class);
        mapper.updateAdmin(new Admin(1, "123", "123"));
    }

    @Test
    public void testCache5() {
        AdminMapper3 mapper = session.getMapper(AdminMapper3.class);
        Admin admin = mapper.selectById(1);
        System.out.println(admin);

    }

}
