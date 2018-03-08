package util;

/**
 * @Author YZ
 * @Date 2018/3/8
 */
public class ClassroomVO {
    int classId;
    String name;
    int allNum;
    double price;
    String teacherName;
    int nowNum;
    String teacherRank;

    public String getTeacherRank() {
        return teacherRank;
    }

    public void setTeacherRank(String teacherRank) {
        this.teacherRank = teacherRank;
    }

    public int getNowNum() {
        return nowNum;
    }

    public void setNowNum(int nowNum) {
        this.nowNum = nowNum;
    }

    public String getTeacherName() {

        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAllNum() {

        return allNum;
    }

    public void setAllNum(int allNum) {
        this.allNum = allNum;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {

        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
