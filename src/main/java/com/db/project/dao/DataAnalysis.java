package com.db.project.dao;

import com.db.project.entity.VCountPayrollByMonthEntity;
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

public class DataAnalysis {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public DataAnalysis() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<HashMap<String, String>> CountPayrollByYear(){
        // 实例化Session
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from VCountPayrollEntity p";
            Query query = session.createQuery(hql);
            tx.commit();
            List<HashMap<String, String>> rst = new ArrayList<HashMap<String, String>>();
            List<VCountPayrollEntity> queryList = query.list();
            HashMap<String, String> tempMap;
            for(int i=0; i<queryList.size(); i++) {
                tempMap = new HashMap<String, String>();
                tempMap.put("DName", queryList.get(i).getdName());
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

    public List<HashMap<String, String>> CountPayrollByMonth() {
        // 实例化Session
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from VCountPayrollByMonthEntity p";
            Query query = session.createQuery(hql);
            tx.commit();
            List<HashMap<String, String>> rst = new ArrayList<HashMap<String, String>>();
            List<VCountPayrollByMonthEntity> queryList = query.list();
            HashMap<String, String> tempMap;
            for(int i=0; i<queryList.size(); i++) {
                tempMap = new HashMap<String, String>();
                tempMap.put("DName", queryList.get(i).getdName());
                tempMap.put("Payroll", String.valueOf(queryList.get(i).getPayroll()));
                tempMap.put("Max", String.valueOf(queryList.get(i).getMax()));
                tempMap.put("Min", String.valueOf(queryList.get(i).getMin()));
                tempMap.put("Date", String.valueOf(queryList.get(i).getDate()));
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
        System.out.println(new DataAnalysis().CountPayrollByMonth());
    }

}
