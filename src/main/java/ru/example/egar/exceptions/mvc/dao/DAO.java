package ru.example.egar.exceptions.mvc.dao;

import ru.example.egar.exceptions.mvc.exceptions.DaoException;

public class DAO {

    public static void doSomething() throws DaoException, RuntimeException {
        int i = (int) (Math.random() * 10);
        if (i > 5) {
            throw new DaoException("Error DaoException");
        } else {
            throw new RuntimeException("Error RuntimeException");
        }
    }
}
