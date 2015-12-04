package com.property.entity;
import org.springframework.web.multipart.MultipartFile;

public class UserProperty {

 private String propertyForEx;
 private String propertyTypeEx;
 private String bhk;
 private double price;
 private int contractPeriod;
 private double securityAmount;
 private String address;
 private String propertyDescription;
 //private MultipartFile image;
 public String getPropertyForEx() {
  return propertyForEx;
 }
 public void setPropertyForEx(String propertyForEx) {
  this.propertyForEx = propertyForEx;
 }
 public String getPropertyTypeEx() {
  return propertyTypeEx;
 }
 public void setPropertyTypeEx(String propertyTypeEx) {
  this.propertyTypeEx = propertyTypeEx;
 }
 public String getBhk() {
  return bhk;
 }
 public void setBhk(String bhk) {
  this.bhk = bhk;
 }
 public double getPrice() {
  return price;
 }
 public void setPrice(double price) {
  this.price = price;
 }
 public int getContractPeriod() {
  return contractPeriod;
 }
 public void setContractPeriod(int contractPeriod) {
  this.contractPeriod = contractPeriod;
 }
 public double getSecurityAmount() {
  return securityAmount;
 }
 public void setSecurityAmount(double securityAmount) {
  this.securityAmount = securityAmount;
 }
 public String getAddress() {
  return address;
 }
 public void setAddress(String address) {
  this.address = address;
 }
 public String getPropertyDescription() {
  return propertyDescription;
 }
 public void setPropertyDescription(String propertyDescription) {
  this.propertyDescription = propertyDescription;
 }
 /*public MultipartFile getImage() {
  return image;
 }
 public void setImage(MultipartFile image) {
  this.image = image;
 }*/
 
}