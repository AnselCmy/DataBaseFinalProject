package com.db.project.dao;

import com.db.project.entity.VCountPayrollEntity;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<HashMap<String, String>> Siri(Say word, String... department){
        // 实例化Session
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "";
            switch (word) {
                case Avg:
                    hql = "from VCountPayrollEntity p";
                    break;
                case Max:
                    hql = "from VCountPayrollEntity p";
                    break;
                case Min:
                    hql = "from VCountPayrollEntity p";
                    break;
                default:
                    System.out.println("please input: Min, Max, Avg + (Dno)");
                    break;
            }
            Query query = session.createQuery(hql);
            tx.commit();
            List<HashMap<String, String>> rst = new ArrayList<HashMap<String, String>>();
            List<VCountPayrollEntity> queryList = query.list();
            HashMap<String, String> tempMap;
            for(int i=0; i<queryList.size(); i++) {
                tempMap = new HashMap<String, String>();
                tempMap.put("DName", queryList.get(i).getdNo());
                tempMap.put("Payroll", String.valueOf(queryList.get(i).getPayroll()));
                tempMap.put("Max", String.valueOf(queryList.get(i).getMax()));
                tempMap.put("Min", String.valueOf(queryList.get(i).getMin()));
                rst.add(tempMap);
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
