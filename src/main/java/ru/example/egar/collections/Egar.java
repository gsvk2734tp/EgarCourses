package ru.example.egar.collections;


public final class Egar {
    private String name;
    private String phone;
    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * Переопределил, так как нужен для работы с Set и фиксированного времени поиска в коллекции O(1)
     * Без equals придется сравнивать все 3 поля каждого элемента, а это O(N^2)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Egar egar = (Egar) o;
        return size == egar.size &&
                name.equals(egar.name) &&
                phone.equals(egar.phone);
    }

    @Override
    public int hashCode() {
        return size;
    }
}
