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

import java.sql.Date;
import org.hibernate.hql.ast.HqlASTFactory;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

public class AttendLogDao{

    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public static enum Opeation {
        Query, Add, Update, Delete
    }

    public AttendLogDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    /**
     * AttendLog表操作
     * */
    public List<AttendLogEntity> opeation(AttendLogDao.Opeation p, AttendLogEntity... entity) {
        List<AttendLogEntity> list = null;
        String hql;
        try {
            //实例化Session
            session = sf.openSession();
            tx = session.beginTransaction();
            switch (p) {
                case Query:
                    hql = "from AttendLogEntity ";
                    list = session.createQuery(hql).list();
                    break;
                case Add:
                    session.save(entity[0]);
                    break;
                case Delete:
                    session.delete(entity[0]);
                    break;
                case Update:
                    session.update(entity[0]);
                    break;
                default:
                    break;
            }
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

    public void addLog(String ENo, String AENo) {
        opeation(Opeation.Add, new AttendLogEntity(ENo, new Date(System.currentTimeMillis()), AENo));
    }

    public void deleteLog(String ENo, String ALDate, String AEName) {
        opeation(Opeation.Delete, new AttendLogEntity(ENo, Date.valueOf(ALDate), AEName));
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
