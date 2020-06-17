package com.edda.dto;

public class CloneDto implements Cloneable{

    private Integer id;

    private String name;

    private CloneInfoDto cloneInfoDto;

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

    public CloneInfoDto getCloneInfoDto() {
        return cloneInfoDto;
    }

    public void setCloneInfoDto(CloneInfoDto cloneInfoDto) {
        this.cloneInfoDto = cloneInfoDto;
    }

    @Override
    public String toString() {
        return "CloneDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cloneInfoDto=" + cloneInfoDto +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return (CloneDto)super.clone();
//        cloneDto.setCloneInfoDto((CloneInfoDto)cloneDto.getCloneInfoDto().clone());
//        return cloneDto;
    }

}
