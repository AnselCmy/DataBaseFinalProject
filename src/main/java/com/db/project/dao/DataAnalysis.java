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

    public List<HashMap<String, List<HashMap<String, String>>>> CountPayrollByMonth() {
        // 实例化Session
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from VCountPayrollByMonthEntity p ";
            Query query = session.createQuery(hql);
            tx.commit();
            List<HashMap<String, List<HashMap<String, String>>>> rst = new ArrayList<HashMap<String, List<HashMap<String, String>>>>();
            List<VCountPayrollByMonthEntity> queryList = query.list();
            HashMap<String, String> inside;
            List<HashMap<String, String>> myList = new ArrayList<HashMap<String, String>>();
            for(int i=0; i<queryList.size(); i++) {
                inside = new HashMap<String, String>();
                inside.put("DName", queryList.get(i).getdName());
                inside.put("Payroll", String.valueOf(queryList.get(i).getPayroll()));
                inside.put("Max", String.valueOf(queryList.get(i).getMax()));
                inside.put("Min", String.valueOf(queryList.get(i).getMin()));
                myList.add(inside);
            }
            ArrayList<HashMap<String, String>> addList;
            HashMap<String, List<HashMap<String, String>>> addHash;
            for(int i=0; i<12; i++) {
                addList = new ArrayList<HashMap<String, String>>();
                for(int j=0; j<10; j++) {
                    addList.add(myList.get(j*12 + i));
                }
                addHash = new HashMap<String, List<HashMap<String, String>>>();
                addHash.put(String.valueOf(i), addList);
                rst.add(addHash);
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
