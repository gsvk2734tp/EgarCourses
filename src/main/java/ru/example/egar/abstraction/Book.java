package ru.example.egar.abstraction;

public class Book extends BaseEntity {

    private String autors;

    public Book(Integer id, String name, String autors) {
        super(id, name);
        this.autors = autors;
    }

    public String getAutors() {
        return autors;
    }

    public void setAutors(String autors) {
        this.autors = autors;
    }
}
