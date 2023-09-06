package com.enviro.assessment.grad001.ipelengmothibi.product;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{investorId}")
    public ResponseEntity<Page<List<ProductDto>>>
    getProductsByInvestor(@PathVariable String investorId, @RequestParam(value = "0") int page,
                          @RequestParam(value = "50") int size) {
        Pageable pageable = PageRequest.of(page,size);
       Page<List<ProductDto>> productDtoPage = productService.getProductByInvestor(investorId, pageable);

       return ResponseEntity.ok(productDtoPage);
    }

    @PostMapping("")
    public ResponseEntity<ProductDto> createProduct(@RequestBody @Valid ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }
}
