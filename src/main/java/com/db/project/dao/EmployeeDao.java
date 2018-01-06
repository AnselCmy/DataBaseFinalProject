package com.db.project.dao;

import com.db.project.entity.EmployeeEntity;
import com.db.project.entity.VEmployeeEntity;
import net.sf.json.JSONArray;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao{
    private Session session = null;
    private Transaction tx = null;
    private Configuration conf = null;
    private SessionFactory sf = null;

    public EmployeeDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    /**
     * 查询Employee表所有数据
     * */
    public List<EmployeeEntity> query() {
        List<EmployeeEntity> list = null;
        try {
            //实例化Session
            session = sf.openSession();
            tx = session.beginTransaction();
            String hql = "from EmployeeEntity ";
            list = session.createQuery(hql).list();
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

    public void add(EmployeeEntity employee) {   //增
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    public void delete(String id) {   //删
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.delete(session.get(EmployeeEntity.class, id));
            tx.commit();
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    public void update(EmployeeEntity employee) {   //更新
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            session.update(employee);
            tx.commit();
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    public EmployeeEntity getById(int id) {    //查
        try {
            session = sf.openSession();
            tx = session.beginTransaction();
            EmployeeEntity find = (EmployeeEntity) session.get(EmployeeEntity.class, id);
            tx.commit();
            return find;
        }
        catch (HibernateException e) {
            tx.rollback();
            throw new RuntimeException(e);
        }
        finally {
            session.close();
        }
    }

    public EmployeeEntity getEntityByENo(String ENo) {
        List<EmployeeEntity> rstList;
        session = sf.openSession();
        String hql = "from EmployeeEntity e where e.eNo = :ENo";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        rstList = query.list();
        return rstList.get(0);
    }

    public List<ArrayList<String>> getAllEntityWithList() {
        List<VEmployeeEntity> queryList;
        session = sf.openSession();
        String hql = "from VEmployeeEntity";
        Query query = session.createQuery(hql);
        queryList = query.list();
        ArrayList<String> temp;
        ArrayList<ArrayList<String>> rstList = new ArrayList<ArrayList<String>>();
        for(VEmployeeEntity entity: queryList) {
            temp = new ArrayList<String>();
            temp.add(entity.geteNo());
            temp.add(entity.geteId());
            temp.add(entity.geteName());
            temp.add(entity.geteSex());
            temp.add(entity.geteEntryDate().toString());
            temp.add(entity.getdName());
            temp.add(entity.getPosName());
            temp.add(entity.geteTel());
            temp.add(entity.geteAge().toString());
            rstList.add(temp);
        }
        return rstList;
    }

//    public JSONArray getAllEntityWithList() {
//        List<VEmployeeEntity> queryList;
//        session = sf.openSession();
//        String hql = "from VEmployeeEntity";
//        Query query = session.createQuery(hql);
//        queryList = query.list();
//        return JSONArray.fromObject(queryList);
//    }
}
