package com.db.project.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

public class DataAnalysis {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    enum Say {
        Min, Max, Avg
    }

    public DataAnalysis() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<String> Siri(Say word, String... department){
        // 实例化Session
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "";
            switch (word) {
                case Avg:
                    hql = "select avg(p.pPayroll) from PayrollEntity p, EmployeeEntity e where e.eNo = p.eNo group by (e.dNo)";
                    break;
                case Max:
                    hql = "select max(p.pPayroll) from PayrollEntity p group by (p.pDate)";
                    break;
                case Min:
                    hql = "select min(p.pPayroll) from PayrollEntity p group by (p.pDate)";
                    break;
                default:
                    System.out.println("please input: Min, Max, Avg + (Dno)");
                    break;
            }
            Query query = session.createQuery(hql);
            tx.commit();
            List<String> rst = new ArrayList<String>();
            List queryList = query.list();
            for(int i=0; i<queryList.size(); i++) {
                rst.add(String.valueOf(queryList.get(i)));
            }
            return rst;
        } catch (HibernateException e) {
            tx.rollback();
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DataAnalysis().Siri(Say.Avg));
    }
}
