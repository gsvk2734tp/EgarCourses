package ru.example.egar.abstraction;

public class Pet extends BaseEntity {

    private boolean sex;

    public Pet(Integer id, String name, boolean sex) {
        super(id, name);
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
