package com.example.demo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Alien {


    private int id;
    private String name;
    private String Tech;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + ", Tech=" + Tech + "]";
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTech() {
        return Tech;
    }
    public void setTech(String tech) {
        Tech = tech;
    }

    
    
}
