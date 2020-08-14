package com.gec.exception;

public class MyException extends Exception{
    private String massage;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public MyException(String massage) {
        this.massage = massage.trim();
    }
}
