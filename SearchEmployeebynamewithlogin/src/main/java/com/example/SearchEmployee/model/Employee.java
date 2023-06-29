package com.example.SearchEmployee.model;

import jakarta.persistence.*;

@Entity

@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String ename;
    private String mobile;
    private String address;



    public Employee() {

    }
    public Employee(int id, String firstName, String  mobile, String address) {

        this.id = id;
        this.ename = ename;
        this.mobile = mobile;
        this.address = address;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getEname() {
        return ename;
    }
    public void setEname(String ename) {
        this.ename= ename;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", ename=" + ename + ", mobile=" + mobile + ", address=" + address + "]";
    }
}
