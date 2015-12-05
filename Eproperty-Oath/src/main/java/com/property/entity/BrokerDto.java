package com.property.entity;
public class BrokerDto {
    private String firstName;
    private String lastName;
    private String type;
    private String networkId;
    private String brokerId;
    private String branchId;
    private long createdTym;
    private int age;
    private boolean activeStatus;
    private String channelId;
    private String ChannelName;
    private String pwd;
    private String enKey;

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNetworkId() {
        return this.networkId;
    }

    public void setNetworkId(String networkId) {
        this.networkId = networkId;
    }

    public String getBrokerId() {
        return this.brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getBranchId() {
        return this.branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public long getCreatedTym() {
        return this.createdTym;
    }

    public void setCreatedTym(long createdTym) {
        this.createdTym = createdTym;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return this.ChannelName;
    }

    public void setChannelName(String channelName) {
        this.ChannelName = channelName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEnKey() {
        return this.enKey;
    }

    public void setEnKey(String enKey) {
        this.enKey = enKey;
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