package com.erha.crmtest.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassNamemyBatisUtil
 * @Description TODO
 * @Author DELL
 * @Date 2021/10/811:33
 * @Version 1.0
 **/
public class myBatisUtil {
    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    private myBatisUtil(){}

    static{
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession == null){
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    public static void commitAndClose(SqlSession sqlSession){
        sqlSession.commit();
        sqlSession.close();
        threadLocal.remove();
    }
}
