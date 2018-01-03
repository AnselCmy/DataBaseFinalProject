package com.db.project.dao;

import com.db.project.entity.StudentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import java.util.List;

public class StudentDao {
    /**
     * 查询Stage表所有数据
     * */
    public List<StudentEntity> query() {
        Session session = null;
        List<StudentEntity> list = null;
        try {
            //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
            Configuration conf = new Configuration().configure();
            //以Configuration创建SessionFactory
            SessionFactory sf = conf.buildSessionFactory();
            //实例化Session
            session = sf.openSession();
            String hql = "from StudentEntity ";
            Query query = session.createQuery(hql);
            list = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return list;
    }
}
