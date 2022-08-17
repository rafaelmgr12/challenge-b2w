package com.rafaelmgr12.challengeb2w.repository;


import com.rafaelmgr12.challengeb2w.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select a from Product a where a.date >= :begindate AND a.date <= :finaldate")
    List<Product> findProductByDateBetween(@Param("begindate") LocalDateTime begindate, @Param("finaldate") LocalDateTime finaldate);
}