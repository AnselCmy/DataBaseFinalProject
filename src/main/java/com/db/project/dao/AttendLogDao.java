package com.db.project.dao;

import com.db.project.entity.AttendLogEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.sql.Date;
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
        try {
            //实例化Session
            session = sf.openSession();
            String hql;
            tx = session.beginTransaction();
            switch (p) {
                case Query:
                    hql = "from AttendLogEntity ";
                    list = session.createQuery(hql).list();
                    break;
                case Add:
                    session.save(entity);
                    break;
                case Delete:
                    session.delete(entity);
                    break;
                case Update:
                    session.update(entity);
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

    public void addLog(String ENo, String AENo) {
        opeation(Opeation.Add, new AttendLogEntity(ENo, new Date(System.currentTimeMillis()), AENo));
    }

    public void deleteLog(String ENo, String ALDate, String AEName) {

    }

}
