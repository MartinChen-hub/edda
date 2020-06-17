package com.edda.dto;

import java.io.Serializable;

public class SerializationDto implements Serializable {

    private Integer id;

    private String name;

    /*非基本类型字段也必须要实现Serializable接口，否则会报org.apache.commons.lang3.SerializationException: java.io.NotSerializableException*/
    private SerializationInfoDto serializationInfoDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SerializationInfoDto getSerializationInfoDto() {
        return serializationInfoDto;
    }

    public void setSerializationInfoDto(SerializationInfoDto serializationInfoDto) {
        this.serializationInfoDto = serializationInfoDto;
    }

    @Override
    public String toString() {
        return "SerializationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", serializationInfoDto=" + serializationInfoDto +
                '}';
    }
}
