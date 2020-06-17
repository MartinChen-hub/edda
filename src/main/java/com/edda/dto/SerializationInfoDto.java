package com.edda.dto;

import java.io.Serializable;

public class SerializationInfoDto implements Serializable {

    private String address;

    private String email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
