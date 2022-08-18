package com.rafaelmgr12.challengeb2w.dto;

import com.rafaelmgr12.challengeb2w.entity.Product;
import org.hibernate.Hibernate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ProductDto {
    private String name;
    private Integer code;
    private LocalDateTime date;
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

    public ProductDto(){}
    public ProductDto(Product product) {
        this.name = product.getName();
        this.code = product.getCode();
        this.date = product.getDate();
        this.dimension = product.getDimension();
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;

        return Objects.equals(code, product.getCode());

    }
    @Override
    public int hashCode() {
        return 2042274511;
    }
    public static List<ProductDto> convert(List<Product> revenues){
        return revenues.stream().map(ProductDto::new).collect(java.util.stream.Collectors.toList());
    }

}
