package com.example.demo;

import com.example.demo.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

    @Query("SELECT p FROM Phone p WHERE " +
            "LOWER(p.make) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(p.model) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    List<Phone> findByMakeOrModel(@Param("searchTerm") String searchTerm);

}
