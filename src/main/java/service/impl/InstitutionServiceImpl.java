package service.impl;

import dao.InstitutionDao;
import model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.InstitutionService;

import java.util.List;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
@Service
@Transactional
public class InstitutionServiceImpl implements InstitutionService{
    @Autowired
    private InstitutionDao institutionDao;


    public List<Institution> getAllIns() {
        return institutionDao.getAllIns();
    }

    public List<String> getAllInsName() {
        return institutionDao.getAllInsName();
    }

    public List<String> getAllLocation() {
        return institutionDao.getAllLocation();
    }
}
