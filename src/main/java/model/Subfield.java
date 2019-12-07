package model;

public class Subfield {

    public Subfield(String subField) {
        this.subField = subField;
    }

    private String subField;

    public String getSubField() {
        return subField;
    }

    public void setSubField(String subField) {
        this.subField = subField;
    }

    @Override
    public String toString() {
        return this.subField;
    }
}