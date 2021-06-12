package com.nuwe.entity;

public class Country {

    private String id;
    private String name;
    private String[] alphaCode; //{code2, code3}
    private int callingCode;

    public Country() {
    }

    public Country(String id, String name, String[] alphaCode, int callingCode) {
        this.id = id;
        this.name = name;
        this.alphaCode = alphaCode;
        this.callingCode = callingCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String[] alphaCode) {
        this.alphaCode = alphaCode;
    }

    public int getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(int callingCode) {
        this.callingCode = callingCode;
    }
}
