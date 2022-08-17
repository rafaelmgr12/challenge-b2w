package com.rafaelmgr12.challengeb2w.controller;

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

@RestController
@RequestMapping("/challenge-backend")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = repository.findAll();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/item")
    public ResponseEntity<List<Product>> getProductByDate(
            @RequestParam(value = "begindate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date beginDate,
            @RequestParam(value="finaldate", required = false) @DateTimeFormat(pattern="dd-MM-yyyy") Date finalDate
    ){
        List<Product> products = repository.findProductByDateBetween(
                beginDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime(),
                finalDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        return ResponseEntity.ok().body(products);
    }


}
