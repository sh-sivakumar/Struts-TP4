package com.hr.struts.model.entities;

public class Employee {

    private String name;
    private String ssNum;
    private String phone;
    
    public Employee(String name, String ssNum, String phone){
        this.name = name;
        this.ssNum = ssNum;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
