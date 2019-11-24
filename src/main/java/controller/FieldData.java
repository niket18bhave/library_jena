package controller;

public class FieldData {
    private String filedname;

    public FieldData(String filedname) {
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
