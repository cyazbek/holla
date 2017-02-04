package com.chrisyazbek.holla;

/**
 * Created by ychri on 2/4/2017.
 */

public class Kontacts {
    private String name;
    private String number;

    public Kontacts(String name, String number){
        this.name = name;
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

}

