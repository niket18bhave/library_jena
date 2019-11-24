package model;

public class FieldDataModel {
    private String filedname;

    public FieldDataModel(String filedname) {
        this.filedname = filedname;
    }

    public String getFiledname() {
        return filedname;
    }

    public void setFiledname(String filedname) {
        this.filedname = filedname;
    }

    @Override
    public String toString() {
        return filedname;
    }
}
