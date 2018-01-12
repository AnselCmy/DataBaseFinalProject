package com.db.project.dao;

import com.db.project.entity.AttendEventEntity;
import com.db.project.entity.SubsidyEventEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubsidyEventDao {
    private Session session = null;
    private Transaction tx = null;
    Configuration conf = null;
    SessionFactory sf = null;

    public SubsidyEventDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    public List<HashMap<String, String>> getAllEventWithMap() {
        List<SubsidyEventEntity> queryList;
        session = sf.openSession();
        String hql = "from SubsidyEventEntity";
        Query query = session.createQuery(hql);
        queryList = query.list();
        HashMap<String, String> temp;
        ArrayList<HashMap<String, String>> rstList = new ArrayList<HashMap<String, String>>();
        for(SubsidyEventEntity entity: queryList) {
            temp = new HashMap<String, String>();
            temp.put("SENo", entity.getSeNo());
            temp.put("SEName", entity.getSeName());
            rstList.add(temp);
        }
        session.close();
        return rstList;
    }
}
