package dao;

import dao.impl.InstitutionDaoImpl;
import dao.impl.VipDaoImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author YZ
 * @Date 2018/6/12
 */
@ContextConfiguration("/applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class InstitutionDAOTest extends TestCase{
    @Autowired
    private InstitutionDaoImpl institutionDaoImpl;

    @Test
    public void testIns(){
//        institutionDaoImpl.getOrderNumChange(8000001);
        institutionDaoImpl.getTop5(8000001);
    }
}
