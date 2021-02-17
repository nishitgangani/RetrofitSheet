
package com.example.retrofitsheet.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sheet1 {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("country")
    @Expose
    private String country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
