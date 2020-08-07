package com.yc.collection.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisHelper {
    private static SqlSessionFactory sqlSessionFactory;
    //动态块
    static {
        try{
            //配置文件
            String resource="mybatis.xml";
            //读入文件
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //构建会话工厂
            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }
}
