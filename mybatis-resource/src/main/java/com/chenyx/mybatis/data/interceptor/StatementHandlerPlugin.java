package com.chenyx.mybatis.data.interceptor;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

import java.sql.Connection;
import java.util.Properties;

/**
 * @desc StatementHandler插件
 * @author chenyx
 * @date 2020-01-07
 * */
@Intercepts({@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class,Integer.class})})
public class StatementHandlerPlugin implements Interceptor{
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("StatementHandlerPlugin.......");
        Connection connection = (Connection) invocation.getArgs()[0];
        Integer integer = (Integer) invocation.getArgs()[1];
        System.out.println("connection:" + connection.getSchema());
        System.out.println("integer :" + integer);
        return  invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
