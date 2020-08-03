package com.edda.utils;

import com.edda.dto.CloneDto;
import com.edda.dto.CloneInfoDto;
import com.edda.dto.SerializationDto;
import com.edda.dto.SerializationInfoDto;
import org.apache.commons.lang3.SerializationUtils;
import org.bouncycastle.util.Arrays;

import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

public class Test {
    public static final int i;

    public volatile String s;

    static{
        i = 0;
    }

    public static void interviewTest(Byte b){
        System.out.println("interviewTest " +b);
        b = b++;

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ConcurrentHashMap<String, String> hashMap = new ConcurrentHashMap<>();
        hashMap.put("1","2");

        System.out.println(hashMap.toString());

        String s = "陈伟炎";
        String pStr = "\\d\\D";
        Pattern p = Pattern.compile(pStr);
        if(p.matcher(s).matches()){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        String tempStr = "";
        tempStr = new String(s.getBytes("utf-8"),"utf-8");
        tempStr = tempStr.trim();
        System.out.println(4.0-3.3);

        String s1="hello world";

        String s2=new String("hello world");

        //hashcode相同对象不一定相同
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1==s2);

        Father f = new Father();
        f.fatherTest("test");
    }
}
