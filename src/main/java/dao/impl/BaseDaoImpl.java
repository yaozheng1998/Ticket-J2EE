package dao.impl;

import dao.BaseDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/2/24
 */
@Repository
public class BaseDaoImpl implements BaseDao{
    @Autowired
    protected SessionFactory sessionFactory;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Session getNewSession() {
        return sessionFactory.openSession();
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    public List getAllList(Class c) {
        String hql="from "+c.getName();
        Session session=getSession();
        return session.createQuery(hql).list();
    }

    public Long getTotalCount(Class c) {
        Session session=getNewSession();
        String hql="select count(*) from "+c.getName();
        Long count=(Long) session.createQuery(hql).uniqueResult();
        session.close();
        return count!=null?count.longValue():0;
    }

    public Object load(Class c, String id) {
        Session session=getSession();
        return session.get(c,id);
    }

    public Object load(Class c, int id) {
        Session session=getSession();
        return session.get(c,id);
    }

    public void save(Object obj) {
        try{
            Session session=getNewSession();
            Transaction transaction=session.beginTransaction();
            session.save(obj);
            session.flush();
            transaction.commit();
            session.clear();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void update(Object obj) {
        try {
            Session session = getNewSession();
            Transaction transaction = session.beginTransaction();
            session.update(obj);
            session.flush();
            transaction.commit();
            session.clear();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Object obj) {
        try {
            Session session = getNewSession();
            Transaction transaction = session.beginTransaction();
            session.delete(obj);
            session.flush();
            transaction.commit();
            session.clear();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(Class c, String id) {
        Object obj=getSession().get(c,id);
        if(obj!=null){
            getSession().delete(obj);
        }
    }

    public void delete(Class c, int id) {
        Object obj=getSession().get(c,id);
        if(obj!=null){
            getSession().delete(obj);
        }
    }

    public void delete(Class c, String[] ids) {
        for(String id:ids){
            Session session=getSession();
            Object obj=session.get(c,id);
            if(obj!=null){
                getSession().delete(obj);
            }
        }
    }

    public List query(String hql) {
        Session session=getSession();
        return session.createQuery(hql).list();
    }

    public List querySQL(String sql) {
        Session session=getSession();
        return session.createSQLQuery(sql).list();
    }

    public Long getCount(String hql) {
        Session session=getNewSession();
        Long count=(Long) session.createQuery(hql).uniqueResult();
        session.close();
        return count!=null? count.longValue():0;
    }

    public int excuteBySql(String sql) {
        int result;
        Session session=getSession();
        SQLQuery query=session.createSQLQuery(sql);
        result=query.executeUpdate();
        return result;
    }
}
