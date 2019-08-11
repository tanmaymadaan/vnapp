package com.tanmaymadaan.vn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Patient {
    @SerializedName("mrdNo")
    @Expose
    private String mrdNo;

    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    public String getMrdNo() {
        return mrdNo;
    }

    public Patient(String mrdNo, String firstName, String lastName) {
        this.mrdNo = mrdNo;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
