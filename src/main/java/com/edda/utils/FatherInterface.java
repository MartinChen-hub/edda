package com.edda.utils;

public interface FatherInterface {
    default void fatherTest(String str){
        System.out.println(str);
    }
}
