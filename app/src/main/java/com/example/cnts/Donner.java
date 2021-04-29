package com.example.cnts;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Donner {
    private String uid = "";
    private String Name = "";
    private String PhoneNumber = "";
    private String BloodType = "";
    private Double Weight = 0.0;
    private Double Height = 0.0;
    private String BirthDate = "";
    private String CreationDate = "";
    private Integer Donated = 0;

    public Donner() {

    }

    public Donner(String uid, String name, String phoneNumber, String bloodType, Double weight, Double height, String birthDate, String creationDate, Integer donated) {
        this.uid = uid;
        Name = name;
        PhoneNumber = phoneNumber;
        BloodType = bloodType;
        Weight = weight;
        Height = height;
        BirthDate = birthDate;
        CreationDate = creationDate;
        Donated = donated;
    }

    @Override
    public String toString() {
        return "Donner{" +
                "uid='" + uid + '\'' +
                ", Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", BloodType='" + BloodType + '\'' +
                ", Weight=" + Weight +
                ", Height=" + Height +
                ", BirthDate='" + BirthDate + '\'' +
                ", CreationDate='" + CreationDate + '\'' +
                ", Donated=" + Donated +
                '}';
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("Name", Name);
        result.put("PhoneNumber", PhoneNumber);
        result.put("BloodType", BloodType);
        result.put("Weight", Weight);
        result.put("Height", Height);
        result.put("BirthDate", BirthDate);
        result.put("CreationDate", CreationDate);
        result.put("Donated", Donated);
        return result;
    }

    public String getUid() {
        return uid;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getBloodType() {
        return BloodType;
    }

    public Double getWeight() {
        return Weight;
    }

    public Double getHeight() {
        return Height;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public Integer getDonated() {
        return Donated;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public void setWeight(Double weight) {
        Weight = weight;
    }

    public void setHeight(Double height) {
        Height = height;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public void setDonated(Integer donated) {
        Donated = donated;
    }
}
