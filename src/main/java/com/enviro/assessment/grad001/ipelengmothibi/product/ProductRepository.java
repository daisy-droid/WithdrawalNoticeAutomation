package com.enviro.assessment.grad001.ipelengmothibi.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<ProductDto, String> {
    Page<List<ProductDto>> findByInvestorId(String investorId, Pageable pageable);
}
