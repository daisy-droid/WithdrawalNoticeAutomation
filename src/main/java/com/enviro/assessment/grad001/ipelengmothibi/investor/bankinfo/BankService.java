package com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    BankRepository bankRepository;

    BankDto createBank(BankDto bank) {
        return bankRepository.save(bank);
    }

}
