package com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("investor/bank")
public class BankController {
    @PostMapping("")
    public ResponseEntity<BankDto> createBankInfo(@RequestBody @Valid BankDto bankDto) {
        return new ResponseEntity<>(bankDto, HttpStatus.CREATED);
    }
}
