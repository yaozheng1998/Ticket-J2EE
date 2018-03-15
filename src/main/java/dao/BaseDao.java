package dao;

import org.hibernate.Session;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/2/24
 */
public interface BaseDao {
    public Session getSession();

    public Session getNewSession();

    public void flush();

    public void clear();

    public List getAllList(Class c);

    public Long getTotalCount(Class c);

    public Object load(Class c, String id);

    public Object load(Class c,int id);

    public void save(Object obj);

    public void update(Object obj);

    public void delete(Object obj);

    public void delete(Class c,String id);

    public void delete(Class c,int id);

    public void delete(Class c,String[] ids);

    public List query(String hql);

    public List querySQL(String sql);

    public Long getCount(String hql);

    public int excuteBySql(String sql);
}