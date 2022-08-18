package com.rafaelmgr12.challengeb2w.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
public class Product {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private LocalDateTime date;

    @ElementCollection
    private Map<String, String> dimension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Map<String, String> getDimension() {
        return dimension;
    }

    public void setDimension(Map<String, String> dimension) {
        this.dimension = dimension;
    }
}
