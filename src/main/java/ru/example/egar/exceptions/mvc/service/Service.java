package ru.example.egar.exceptions.mvc.service;

import ru.example.egar.exceptions.mvc.dao.DAO;
import ru.example.egar.exceptions.mvc.exceptions.CloseException;
import ru.example.egar.exceptions.mvc.exceptions.DaoException;
import ru.example.egar.exceptions.mvc.exceptions.ServiceException;

public class Service {

    public static void doSomething() {
        try {
            DAO.doSomething();
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException("Error ServiceException");
        }
    }

    public static void close() {
        throw new CloseException("Error CloseException");
    }
}
