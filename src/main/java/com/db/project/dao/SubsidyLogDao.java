package com.db.project.dao;

import com.db.project.entity.VAttendLog2Entity;
import com.db.project.entity.VSubsidyLogEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

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
        String hql = "from VSubsidyLogEntity v where v.eNo = :ENo";
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
}
