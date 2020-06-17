package com.edda.dto;

public class CloneInfoDto{
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

//    @Override
//    public String toString() {
//        return "CloneInfoDto{" +
//                "address='" + address + '\'' +
//                ", email='" + email + '\'' +
//                '}';
//    }

//    @Override
//    public Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }
}
