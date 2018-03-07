package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author YZ
 * @Date 2018/3/7
 */
public class CourseVO {
    int courseId;
    String insName;
    String insLoc;
    String startTime;
    String endTime;
    double basicPrice;
    int times;
    String subject;

    DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getTimes() {

        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public double getBasicPrice() {

        return basicPrice;
    }

    public void setBasicPrice(double basicPrice) {
        this.basicPrice = basicPrice;
    }

    public Date getEndTime() throws ParseException {
        return sdf.parse(endTime);
    }

    public void setEndTime(String endTime) {

        this.endTime = endTime;
    }

    public Date getStartTime() throws ParseException {

        return sdf.parse(startTime);
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getInsLoc() {

        return insLoc;
    }

    public void setInsLoc(String insLoc) {
        this.insLoc = insLoc;
    }
}
