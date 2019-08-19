package com.tanmaymadaan.vn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Patient {



    @SerializedName("pId")
    @Expose
    private String pId;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("phoneNo")
    @Expose
    private String phoneNo;

    @SerializedName("age")
    @Expose
    private String age;

    @SerializedName("idType")
    @Expose
    private String idType;

    @SerializedName("idNo")
    @Expose
    private String idNo;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("guardian")
    @Expose
    private String guardian;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("state")
    @Expose
    private String state;


    public Patient(String pId, String firstName, String lastName, String phoneNo, String age, String idType, String idNo, String gender, String guardian, String address, String city, String state) {
        this.pId = pId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.age = age;
        this.idType = idType;
        this.idNo = idNo;
        this.gender = gender;
        this.guardian = guardian;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getpId() { return pId; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getAge() {
        return age;
    }

    public String getIdType() {
        return idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public String getGender() {
        return gender;
    }

    public String getGuardian() {
        return guardian;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }


}