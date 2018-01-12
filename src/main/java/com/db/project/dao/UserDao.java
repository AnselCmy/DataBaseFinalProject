package com.db.project.dao;

import com.db.project.entity.UserEntity;
import com.db.project.entity.VEmployeeEntity;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import java.util.List;

public class UserDao {
    private Session session;
    private Configuration conf;
    private SessionFactory sf;

    public UserDao() {
        //实例化Configuration，这行代码默认加载hibernate.cfg.xml文件
        conf = new Configuration().configure();
        //以Configuration创建SessionFactory
        sf = conf.buildSessionFactory();
    }

    /*
    如果有相应的用户，则返回该用户的UserEntity
    否则返回null
     */
    public UserEntity CheckUser(String id, String password) {
        // 实例化Session
        session = sf.openSession();
        List<UserEntity> rstList;
        UserEntity userEntity;
        // 查询语句
        String hql = "from UserEntity u where u.eNo = :id and u.uPassword = :password";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.setParameter("password", password);
        // 返回查询结果
        rstList = query.list();
        session.close();
        // 处理查询结果
        if(rstList.toArray().length == 1) {
            userEntity = rstList.get(0);
        }
        else {
            userEntity = null;
        }

        return userEntity;
    }

    /*
    通过用户的工号获取用户的等级
    返回"1"表示为管理员，"0"为一般用户
     */
    public String getLevelByENo(String ENo) {
        List<String> rstList;
        session = sf.openSession();
        String hql = "select u.uLevel from UserEntity u where u.eNo = :ENo";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        rstList = query.list();
        session.close();
        return rstList.get(0);
    }

    /*
    给指定的用户设置新密码
     */
    public void setNewPassword(String ENo, String UPassword) {
        List<VEmployeeEntity> queryList;
        session = sf.openSession();
        String hql = "update UserEntity u set u.uPassword = :UPassword where u.eNo = :ENo";
        Query query = session.createQuery(hql);
        query.setParameter("ENo", ENo);
        query.setParameter("UPassword", UPassword);
        query.executeUpdate();
        session.close();
    }
}
