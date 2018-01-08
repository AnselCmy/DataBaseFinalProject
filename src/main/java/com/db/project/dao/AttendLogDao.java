package com.db.project.dao;

import com.db.project.entity.AttendLogEntity;
import com.db.project.entity.VAttendLog2Entity;
import com.db.project.entity.VAttendLogEntity;
import com.db.project.entity.VEmployeeEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.hibernate.hql.ast.HqlASTFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendLogDao{

    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public AttendLogDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    /**
     * 查询Employee表所有数据
     * */
    public List<AttendLogEntity> query() {
        List<AttendLogEntity> list = null;
        try {
            //实例化Session
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from AttendLogEntity ";
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

    public void add(AttendLogEntity log) {   //增
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(log);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public void delete(String id) {   //删
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(session.get(AttendLogEntity.class, id));
            tx.commit();
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    public void update(AttendLogEntity log) {   //更新
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.update(log);
            tx.commit();
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    public AttendLogEntity getById(int id) {    //查
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            AttendLogEntity find = (AttendLogEntity) session.get(AttendLogEntity.class, id);
            tx.commit();
            return find;
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    /*
    通过ENo查询某一个人的考勤记录
     */
    public List<HashMap<String, String>> getAttendLogWithMapByENo(String ENo) {
        List<VAttendLog2Entity> queryList;
        session = sf.openSession();
        String hql = "from VAttendLog2Entity v where v.eNo = :ENo";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(VAttendLog2Entity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("ENo", entity.geteNo());
            temp.put("ALDate", entity.getAlDate().toString());
            temp.put("AENo", entity.getAeNo());
            temp.put("AEName", entity.getAeName());
            temp.put("AEMoney", String.valueOf((int)entity.getAeMoney()));
            rstList.add(temp);
        }
        session.close();
        return rstList;
    }
}
