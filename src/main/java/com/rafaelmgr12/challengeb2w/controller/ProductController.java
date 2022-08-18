package com.rafaelmgr12.challengeb2w.controller;

import com.rafaelmgr12.challengeb2w.dto.ProductDto;
import com.rafaelmgr12.challengeb2w.entity.Product;
import com.rafaelmgr12.challengeb2w.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/challenge-backend")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public List<ProductDto> getAllProducts(){
        List<Product> products = (List<Product>) repository.findAll();
        return ProductDto.convert(products);
    }
    @GetMapping("/item")
    public ResponseEntity<List<ProductDto>> getProductByDate(
            @RequestParam(value = "begindate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date beginDate,
            @RequestParam(value="finaldate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date finalDate
    ){
        Optional<List<Product>> products = repository.findProductByDateBetween(
                beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                finalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProductDto.convert((List<Product>) products.get()));
    }


}
