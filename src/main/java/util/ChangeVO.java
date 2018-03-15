package util;

/**
 * @Author YZ
 * @Date 2018/3/15
 */
public class ChangeVO {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nameChange;
    private String locChange;
    private String classChange;

    public ChangeVO(String name,String loc,String cla){
        this.nameChange=name;
        this.locChange=loc;
        this.classChange=cla;
    }
    public String getClassChange() {
        return classChange;
    }

    public void setClassChange(String classChange) {
        this.classChange = classChange;
    }

    public ChangeVO(String classChange) {

        this.classChange = classChange;
    }

    public String getLocChange() {

        return locChange;
    }

    public void setLocChange(String locChange) {
        this.locChange = locChange;
    }

    public String getNameChange() {

        return nameChange;
    }

    public void setNameChange(String nameChange) {
        this.nameChange = nameChange;
    }

    public static ChangeVO getALL(int id,String oldName,String oldLoc,String oldNum,String change){
        ChangeVO vo=new ChangeVO(oldName,oldLoc,oldNum);
        vo.setId(id);
        String[] strings=change.split("-");
        if(!oldName.equals(strings[0])){
            vo.setNameChange(oldName+"改成"+strings[0]);
        }
        if(!oldLoc.equals(strings[1])){
            vo.setLocChange(oldLoc+"改成"+strings[1]);
        }

        if(!oldNum.equals(strings[2])){
            vo.setClassChange(oldNum+"改成"+strings[2]);
        }
        return vo;
    }
}
