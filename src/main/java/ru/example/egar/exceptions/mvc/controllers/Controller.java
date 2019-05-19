package ru.example.egar.exceptions.mvc.controllers;

import ru.example.egar.exceptions.mvc.exceptions.CloseException;
import ru.example.egar.exceptions.mvc.exceptions.ServiceException;
import ru.example.egar.exceptions.mvc.service.Service;

public class Controller {

    public static void main(String[] args) {
        try {
            Service.doSomething();
        } catch (RuntimeException e) {
            e.printStackTrace();
            try {
                throw new ServiceException("Error ServiceException in Controller");
            } catch (ServiceException e1) {
                e1.printStackTrace();
            } catch (RuntimeException e2) {
                e.printStackTrace();
            }
        } finally {
            try {
                Service.close();
            } catch (CloseException e) {
                e.printStackTrace();
            }
        }
    }
}
