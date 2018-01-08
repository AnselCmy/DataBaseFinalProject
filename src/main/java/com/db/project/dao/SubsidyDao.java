package com.db.project.dao;

import com.db.project.entity.SubsidyLogEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.sql.Date;
import java.util.List;

public class SubsidyDao{

    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public static enum Opeation {
        Query, Add, Update, Delete
    }

    public SubsidyDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
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
        opeation(Opeation.Add, new SubsidyLogEntity(ENo, new Date(System.currentTimeMillis()), Float.valueOf(SLMoney), SENo, SLComment));
    }

    public void deleteLog(String ENo, String SLDate, String SLMoney, String SENo, String SLComment) {
        opeation(Opeation.Delete, new SubsidyLogEntity(ENo, Date.valueOf(SLDate), Float.valueOf(SLMoney), SENo, SLComment));
    }

    public static void main(String[] args) {
        new SubsidyDao().addLog("2007000000", "8888", "04", "%测试专用%");
    }
}
