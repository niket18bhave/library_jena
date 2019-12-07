package model;

public class BookDataModel {
    public BookDataModel(String book, String author, String field, String location, String superTopic) {
        this.book = book;
        this.author = author;
        this.field = field;
        this.location = location;
        this.superTopic = superTopic;
    }

    public BookDataModel() {
    }

    private String book;
    private String author;
    private String field;
    private String location;

    public String getSuperTopic() {
        return superTopic;
    }

    public void setSuperTopic(String superTopic) {
        this.superTopic = superTopic;
    }

    private String superTopic;

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book: " + book + "|| Author: " + author + "|| Field: " + field + "|| Location: " +
                location + "|| SuperTopic: "+ superTopic;
    }
}
