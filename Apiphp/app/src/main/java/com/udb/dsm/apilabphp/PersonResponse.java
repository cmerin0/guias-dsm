package com.udb.dsm.apilabphp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PersonResponse {
    @SerializedName("details")
    private List<Person> people;
    public List<Person> getPeopleInfo() {
        return people;
    }
}
