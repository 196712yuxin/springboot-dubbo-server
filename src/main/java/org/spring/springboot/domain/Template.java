package org.spring.springboot.domain;


import org.spring.springboot.base.base.BaseDomain;

public class Template extends BaseDomain {
    private Integer id;
    private String name;
    private String age;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAge() {
        return this.age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String toString() {
        return "Template(id=" + getId() + ", name=" + getName() + ", age=" + getAge() + ")";
    }
}
