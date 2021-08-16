package com.breno.api.domain.entities;


import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

@MappedEntity(value = "USER_TABLE")
public class UserEntity {

    @GeneratedValue(value = GeneratedValue.Type.IDENTITY)
    @Id
    @MappedProperty(value = "ID")
    private Long id;

    @MappedProperty(value = "NAME")
    private String name;

    @MappedProperty(value = "AGE")
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
