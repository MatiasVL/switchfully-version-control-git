package com.switchfully.spring.tax;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxationRepository extends JpaRepository<Taxation, String> {
}
