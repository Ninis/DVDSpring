package com.ninaniskanen.DVDCatalogue.exception;

public class DAOException extends Exception {
    public DAOException(){}

    public DAOException(StackTraceElement[] stackTrace){
        this.setStackTrace(stackTrace);
    }
}
