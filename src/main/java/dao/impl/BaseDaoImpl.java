package dao.impl;

import dao.BaseDao;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Session session=getNewSession();
        session.save(obj);
        session.flush();
        session.clear();
        session.close();
    }

    public void update(Object obj) {
        Session session=getNewSession();
        session.update(obj);
        session.flush();
        session.clear();
        session.close();
    }

    public void delete(Object obj) {
        Session session=getNewSession();
        session.delete(obj);
        session.flush();
        session.clear();
        session.close();
    }

    public void delete(Class c, String id) {
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
