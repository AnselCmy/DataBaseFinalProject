package com.db.project.dao;

import org.hibernate.HibernateException;
import com.db.project.entity.AttendEventEntity;
import com.db.project.entity.VEmployeeEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendEventDao {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public AttendEventDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }
  
    public String queryAENo(String AEName) {
        String hql = "select a.aeNo from AttendEventEntity a where a.aeName = :AEName";
        List list = null;
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(hql);
            query.setParameter("AEName", AEName);
            list = query.list();
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
        return String.valueOf(list.get(0));
    }

    public static void main(String[] args) {
        System.out.println(new AttendEventDao().queryAENo("请假"));
    }
  
    public List<HashMap<String, String>> getAllEventWithMap() {
        List<AttendEventEntity> queryList;
        session = sf.openSession();
        String hql = "from AttendEventEntity";
        Query query = session.createQuery(hql);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(AttendEventEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("AENo", entity.getAeNo());
            temp.put("AEName", entity.getAeName());
            rstList.add(temp);
        }
        session.close();
        return rstList;
    }

}
