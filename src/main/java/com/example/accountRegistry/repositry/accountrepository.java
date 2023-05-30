package com.example.accountRegistry.repositry;

import com.example.accountRegistry.entity.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface accountrepository extends JpaRepository<account, Integer> {

    @Query("SELECT a FROM account a WHERE CONCAT(a.firstName, ' ', a.lastName, ' ', a.phoneNumber, ' ', a.userAddress, ' ', a.userEmail) LIKE %?1%")
    public List<account> search(String keyword);
    // here we will use SQL's % % where the input will replace ?1 into the query and result the rows of the substring that is needed. i.e %Smith% will return all users with last name smith


}
