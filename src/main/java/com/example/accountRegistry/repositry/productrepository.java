package com.example.accountRegistry.repositry;

import com.example.accountRegistry.entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface productrepository extends JpaRepository<product, Integer> {
    @Query("SELECT p FROM product p WHERE CONCAT(p.id, ' ',p.Coffee, ' ', p.herbalPills, ' ', p.tea, ' ', p.medication, ' ', p.accountID) LIKE %?1%")
    public List<product> search(String kw);

}
