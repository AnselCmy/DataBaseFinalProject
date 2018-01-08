package com.db.project.dao;

import com.db.project.entity.AttendEventEntity;
import com.db.project.entity.DepartmentEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DepartmentDao{
    private Session session = null;
    private Transaction tx = null;
    private Configuration conf = null;
    private SessionFactory sf = null;

    public EmployeeDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<HashMap<String, String>> getAllDepartmentWithMap() {
        List<DepartmentEntity> queryList;
        session = sf.openSession();
        String hql = "from DepartmentEntity";
        Query query = session.createQuery(hql);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(DepartmentEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("DNo", entity.getdNo());
            temp.put("DName", entity.getdName());
            rstList.add(temp);
        }
        return rstList;
    }

    /**
     * 查询Department表所有数据
     * */
    public List<DepartmentEntity> query() {
        Session session = null;
        Transaction tx = null;
        List<DepartmentEntity> list = null;
        try {
            //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
            Configuration conf = new Configuration().configure();
            //以Configuration创建SessionFactory
            SessionFactory sf = conf.buildSessionFactory();
            //实例化Session
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from DepartmentEntity ";
            list = session.createQuery(hql).list();
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
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
