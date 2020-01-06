package com.chneyx.mybatis;


import com.chenyx.mybatis.data.UserMapper;
import com.chenyx.mybatis.data.entity.User;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.Reader;
import java.util.List;

public class UseMappingTest {


    @Test
    public void testSelect() throws Exception{
        Reader reader =  Resources.getResourceAsReader("mybatisConfig.xml");
        //定义sqlsessionFactory
        //主要解析mybaitConfig.xml文件
        //生产sqlsessionFactory对应
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //configuration-->mybatis配置文件
        //executor-->mybatis执行sql语句的执行器，不同的执行器。使用方式不一样
        //autoCommit-->是否指定提交
        SqlSession sqlSession = sessionFactory.openSession();
        //获取mapping
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
        System.out.print("user:" +user);
    }




    @Test
    public void testSelectAll() throws Exception{
        Reader reader =  Resources.getResourceAsReader("mybatisConfig.xml");
        //定义sqlsessionFactory
        //主要解析mybaitConfig.xml文件
        //生产sqlsessionFactory对应
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //configuration-->mybatis配置文件
        //executor-->mybatis执行sql语句的执行器，不同的执行器。使用方式不一样
        //autoCommit-->是否指定提交
        SqlSession sqlSession = sessionFactory.openSession();
        //获取mapping
       // List<User> users = sqlSession.selectList("com.chenyx.mybatis.data.UserMapper.selectAll");
        User user = sqlSession.selectOne("com.chenyx.mybatis.data.UserMapper.selectByPrimaryKey",1);
        System.out.print("user:" + user);
    }


    @Test
    public void updateUser() throws Exception{
        Reader reader =  Resources.getResourceAsReader("mybatisConfig.xml");
        //定义sqlsessionFactory
        //主要解析mybaitConfig.xml文件
        //生产sqlsessionFactory对应
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //configuration-->mybatis配置文件
        //executor-->mybatis执行sql语句的执行器，不同的执行器。使用方式不一样
        //autoCommit-->是否指定提交
        SqlSession sqlSession = sessionFactory.openSession();
        //获取mapping
        // List<User> users = sqlSession.selectList("com.chenyx.mybatis.data.UserMapper.selectAll");
        sqlSession.update("com.chenyx.mybatis.data.UserMapper.selectAll.updateByPrimaryKeySelective",1);
    }
}