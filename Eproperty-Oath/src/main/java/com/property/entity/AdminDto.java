package com.property.entity;
import java.io.Serializable;

public class AdminDto
implements Serializable {
    private static final long serialVersionUID = -402208782495210053L;
    private String firstName;
    private String lastName;
    private String adminId;
    private String type;
    private int age;
    private long createdTym;
    private boolean activeStatus;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdminId() {
        return this.adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getCreatedTym() {
        return this.createdTym;
    }

    public void setCreatedTym(long createdTym) {
        this.createdTym = createdTym;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActiveStatus() {
        return this.activeStatus;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }
}