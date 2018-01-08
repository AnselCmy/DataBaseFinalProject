package com.db.project.dao;

import com.db.project.entity.PayrollEntity;
import com.db.project.entity.VAttendLogEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PayrollDao {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public PayrollDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<HashMap<String, String>> getPayrollWithMapByENo(String ENo) {
        List<PayrollEntity> queryList;
        session = sf.openSession();
        String hql = "from PayrollEntity p where p.eNo = :ENo";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(PayrollEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("ENo", entity.geteNo());
            temp.put("PDate", entity.getpDate().toString());
            temp.put("PPayroll", String.valueOf((int)entity.getpPayroll()));
            rstList.add(temp);
        }
        session.close();
        return rstList;
    }
}
