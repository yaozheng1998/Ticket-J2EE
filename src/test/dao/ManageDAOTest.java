package dao;

import dao.impl.ManageDaoImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * @Author YZ
 * @Date 2018/6/13
 */
@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ManageDAOTest extends TestCase {
    @Autowired
    private ManageDaoImpl manageDaoImpl;

    @Test
    public void testIns(){
//        System.out.println(manageDaoImpl.getAboutLocation());
//        Map<String,String> locationMap=manageDaoImpl.getAboutLocation();
//        for(Map.Entry<String,String> entry:locationMap.entrySet()){
//            System.out.println(entry.getValue().split("-")[1]);
//        }
//        manageDaoImpl.getMoneyChange();
        manageDaoImpl.getOkRateChange();
    }
}
