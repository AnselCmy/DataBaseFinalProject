package com.db.project.dao;

import com.db.project.entity.SubsidyLogEntity;
import com.db.project.entity.VAttendLog2Entity;
import com.db.project.entity.VSubsidyLogEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubsidyLogDao {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public SubsidyLogDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    /*
    通过ENo查询某一个人的考勤记录
     */
    public List<HashMap<String, String>> getSubsidyLogWithMapByENo(String ENo) {
        List<VSubsidyLogEntity> queryList;
        session = sf.openSession();
        String hql = "from VSubsidyLogEntity v where v.eNo = :ENo order by v.slDate";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(VSubsidyLogEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("ENo", entity.geteNo());
            temp.put("SLDate", entity.getSlDate().toString());
            temp.put("SENo", entity.getSeNo());
            temp.put("SEName", entity.getSeName());
            temp.put("SLMoney", String.valueOf((int)entity.getSlMoney()));
            temp.put("SLComment", entity.getSlComment());
            rstList.add(temp);
        }
        session.close();
        return rstList;
    }

    /**
     * SubsidyLog表操作
     * */
    public List<SubsidyLogEntity> opeation(SubsidyDao.Opeation p, SubsidyLogEntity... entity) {
        List<SubsidyLogEntity> list = null;
        String hql;
        try {
            //实例化Session
            session = sf.openSession();
            tx = session.beginTransaction();
            switch (p) {
                case Query:
                    hql = "from SubsidyLogEntity ";
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

    public void addLog(String ENo, String SLMoney, String SENo, String SLComment) {
        opeation(SubsidyDao.Opeation.Add, new SubsidyLogEntity(ENo, new Date(System.currentTimeMillis()), Float.valueOf(SLMoney), SENo, SLComment));
    }

    public void deleteLog(String ENo, String SLDate, String SLMoney, String SENo, String SLComment) {
        opeation(SubsidyDao.Opeation.Delete, new SubsidyLogEntity(ENo, Date.valueOf(SLDate), Float.valueOf(SLMoney), SENo, SLComment));
    }
}
