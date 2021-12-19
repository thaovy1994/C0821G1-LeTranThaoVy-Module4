package com.model;

public class Email {
    private String language;
    private String size;
    private String spams;
    private String sign;

    public Email() {
    }

    public Email(String language, String size, String spams, String sign) {
        this.language = language;
        this.size = size;
        this.spams = spams;
        this.sign = sign;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSpams() {
        return spams;
    }

    public void setSpams(String spams) {
        this.spams = spams;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
