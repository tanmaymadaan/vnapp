package com.tanmaymadaan.vn;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Counter {
    @SerializedName("counter")
    @Expose
    private int counter;

    public Counter(int counter) {
        this.counter = counter;
    }

    public int getCounter() {

        return counter;
    }
}
