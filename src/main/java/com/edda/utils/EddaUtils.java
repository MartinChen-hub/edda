package com.edda.utils;

import com.edda.dto.SerializationDto;
import com.edda.dto.SerializationInfoDto;
import com.edda.dto.CloneDto;
import com.edda.dto.CloneInfoDto;
import org.apache.commons.lang3.SerializationUtils;

public class EddaUtils {

    public static void cloneTest() throws CloneNotSupportedException {
        CloneDto dto = new CloneDto();
        dto.setId(1);
        dto.setName("Real别学做大老板");
        CloneInfoDto infoDto = new CloneInfoDto();
        infoDto.setAddress("深圳南山");
        infoDto.setEmail("xxx@qq.com");
        dto.setCloneInfoDto(infoDto);
        CloneDto cloneDto = (CloneDto)dto.clone();
        cloneDto.setId(2);
        cloneDto.setName("Clone别学做大老板");
        cloneDto.getCloneInfoDto().setEmail("xxx@163.com");
        System.out.println(dto.hashCode()+" -> "+dto.toString());
        System.out.println(cloneDto.hashCode()+" -> "+cloneDto.toString());
    }

    public static void SerializationTest(){
        SerializationDto dto = new SerializationDto();
        dto.setId(1);
        dto.setName("Real别学做大老板");
        SerializationInfoDto infoDto = new SerializationInfoDto();
        infoDto.setAddress("深圳南山");
        infoDto.setEmail("xxx@qq.com");
        dto.setSerializationInfoDto(infoDto);
        SerializationDto serializationDto = SerializationUtils.clone(dto);
        serializationDto.setId(2);
        serializationDto.setName("Clone别学做大老板");
        serializationDto.getSerializationInfoDto().setEmail("xxx@163.com");
        System.out.println(dto.hashCode()+" -> "+dto.toString());
        System.out.println(serializationDto.hashCode()+" -> "+serializationDto.toString());
    }

    public static void interviewTest(Byte b){
        System.out.println("interviewTest " +b);
        b = b++;

    }

    public static void main(String[] args){
//        byte b = new byte(10000000);
        int[] i = {};
        System.out.println(1<<7);
    }
}
