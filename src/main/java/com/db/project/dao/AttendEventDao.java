package com.db.project.dao;

import com.db.project.entity.AttendEventEntity;
import com.db.project.entity.VEmployeeEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttendEventDao {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public AttendEventDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<HashMap<String, String>> getAllEventWithMap() {
        List<AttendEventEntity> queryList;
        session = sf.openSession();
        String hql = "from AttendEventEntity";
        Query query = session.createQuery(hql);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(AttendEventEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("AENo", entity.getAeNo());
            temp.put("AEName", entity.getAeName());
            rstList.add(temp);
        }
        return rstList;
    }

}
