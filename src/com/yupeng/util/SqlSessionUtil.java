package com.yupeng.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Yupeng
 * @create 2020-12-21 21:43
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;

    private SqlSessionUtil() {
    }

    static {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }
    private static ThreadLocal<SqlSession> t = new ThreadLocal<>();
    /**
     * 取得SqlSession对象
     * @return
     */
    public static SqlSession getSession(){
        SqlSession session = t.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            t.set(session);
        }
        return session;
    }
    public static void myClose(SqlSession session){
        if (session != null) {
            session.close();
            // 必须移除，使线程回到线程池中
            t.remove();
        }
    }
}
