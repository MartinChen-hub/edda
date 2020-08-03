package com.edda.utils;

public class B extends A{
    static{
        System.out.println("B");
    }
    public B() {
        super();
    }

    public B(String i){
        this();
        i = "9";
    }
}
