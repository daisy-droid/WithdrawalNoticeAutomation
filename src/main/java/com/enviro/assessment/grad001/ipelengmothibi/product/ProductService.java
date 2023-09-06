package com.enviro.assessment.grad001.ipelengmothibi.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    ProductDto createProduct(ProductDto productDto) {
        return productRepository.save(productDto);
    }

    public Page<List<ProductDto>> getProductByInvestor(String investorId, Pageable pageable) {
        return productRepository.findByInvestorId(investorId, pageable);
    }

}
