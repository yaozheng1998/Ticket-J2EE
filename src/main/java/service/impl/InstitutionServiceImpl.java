package service.impl;

import dao.InstitutionDao;
import model.Course;
import model.Institution;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.InstitutionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Institution getInsById(int insId) {
        return institutionDao.getInsById(insId);
    }

    public void addIns(Institution institution) {
        institutionDao.addIns(institution);
    }

    public long getNextId() {
        return institutionDao.getNextId();
    }

    public boolean whetherAct(int insId) {
        return institutionDao.whetherAct(insId);
    }

    public Institution getInfoById(int insId) {
        return institutionDao.getInfoById(insId);
    }

    public boolean checkPass(int id, String password) {
        return institutionDao.checkPass(id,password);
    }

    public void update(Institution institution) {

    }

    public List<Course> getCoursesOfIns(int insId) {
        return institutionDao.getCoursesOfIns(insId);
    }

    public void change(int ins_id, String ins_name, String location, int classrooms) {
        institutionDao.change(ins_id, ins_name, location, classrooms);
    }

    public void setMoney(int ins_id,double money) {
        institutionDao.setMoney(ins_id, money);
    }

    public List<Object[]> getInsOrdersByState(int ins_id,String state) {
        return institutionDao.getInsOrdersByState(ins_id,state);
    }

    public int getOrderNum(int ins_id) {
        return institutionDao.getOrderNum(ins_id);
    }

    public int getStudentNum(int ins_id) {
        return institutionDao.getStudentNum(ins_id);
    }

    public double getMoney(int ins_id) {
        return institutionDao.getMoney(ins_id);
    }

    public int getNumByState(int ins_id, String state) {
        return institutionDao.getNumByState(ins_id, state);
    }

    public HashMap getNumByTeacher(int ins_id) {
        return institutionDao.getNumByTeacher(ins_id);
    }

    public Map<String, Integer> getOrderNumChange(int ins_id) {
        return institutionDao.getOrderNumChange(ins_id);
    }

    public Map<String, Double> getOrderMoneyChange(int ins_id) {
        return institutionDao.getOrderMoneyChange(ins_id);
    }

    public Map<String, Integer> getStudentNumChange(int ins_id) {
        return institutionDao.getStudentNumChange(ins_id);
    }

    public Map<String, String> getOKRateChange(int ins_id) {
        return institutionDao.getOKRateChange(ins_id);
    }

    public Map<String, String> getAveragePrice(int ins_id) {
        return institutionDao.getAveragePrice(ins_id);
    }

    public Map<String, String> getBuyMethod(int ins_id) {
        return institutionDao.getBuyMethod(ins_id);
    }

    public List getTopCourseMonth(int ins_id) {
        return institutionDao.getTopCourseMonth(ins_id);
    }

    public List getTopCourseAll(int ins_id) {
        return institutionDao.getTopCourseAll(ins_id);
    }

    public List getTopClassMonth(int ins_id) {
        return institutionDao.getTopClassMonth(ins_id);
    }

    public List getTopClassAll(int ins_id) {
        return institutionDao.getTopClassAll(ins_id);
    }

    public Map<String, Integer> getClassType(int ins_id) {
        return institutionDao.getClassType(ins_id);
    }

    public Map<String, Integer> getClassStatus(int ins_id) {
        return institutionDao.getClassStatus(ins_id);
    }

    public Map<String, Integer> getClassGrades(int ins_id) {
        return institutionDao.getClassGrades(ins_id);
    }

    public List getTop5(int ins_id) {
        return institutionDao.getTop5(ins_id);
    }
}
