package com.hr.struts.model.entities;

public class Employee {

    private String name;
    private String ssNum;

    public Employee(String name, String ssNum) {
        this.name = name;
        this.ssNum = ssNum;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSsNum(String ssNum) {
        this.ssNum = ssNum;
    }

    public String getSsNum() {
        return ssNum;
    }
}
