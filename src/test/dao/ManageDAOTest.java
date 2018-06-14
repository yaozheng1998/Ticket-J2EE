package dao;

import dao.impl.ManageDaoImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        manageDaoImpl.getAboutLocation();
    }
}
