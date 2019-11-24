package model;

public class LocationDataModel {

    private String Aisle;
    private String Floor;
    private String Field;
    private String Details;

    public LocationDataModel(String aisle, String floor, String field, String details) {
        Aisle = aisle;
        Floor = floor;
        Field = field;
        Details = details;
    }

    public String getAisle() {
        return Aisle;
    }

    public void setAisle(String aisle) {
        Aisle = aisle;
    }

    public String getFloor() {
        return Floor;
    }

    public void setFloor(String floor) {
        Floor = floor;
    }

    public String getField() {
        return Field;
    }

    public void setField(String field) {
        Field = field;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }
}
