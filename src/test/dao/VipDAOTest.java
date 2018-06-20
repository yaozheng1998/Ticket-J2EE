package dao;

import dao.impl.VipDaoImpl;
import junit.framework.TestCase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/6/7
 */
@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class VipDAOTest extends TestCase{
    @Autowired
    private VipDaoImpl vipDaoImpl;

    @Test
    public void testOrderNum(){
        System.out.println(vipDaoImpl.getLatestNum("yz").get(""));
//        vipDaoImpl.getOrderType("yz");
//        vipDaoImpl.getOrderLocation("yz");
//        vipDaoImpl.getOrderOnOffline("yz");
//        vipDaoImpl.getOKrate("yz");
        Map<String,Integer> courseType=vipDaoImpl.getOrderType("yz");
        List<String> courses=new ArrayList<String>(courseType.keySet());
        List<Integer> courseNum=new ArrayList<Integer>(courseType.values());
        System.out.println(courseType);
        System.out.println(courses);
        System.out.println(courseNum);
    }

}
