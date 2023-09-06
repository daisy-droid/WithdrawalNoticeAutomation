package com.enviro.assessment.grad001.ipelengmothibi.investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvestorService {

    @Autowired
    InvestorRepository investorRepository;
    // Get all investors from the database and add pagination to improve the api performance
    public Page<InvestorDto> getAllInvestors(Pageable pageable) {
        return investorRepository.findAll(pageable);
    }

    // Get an investor info by using the identifier, does not need pagination as I am returning 1 investor
    public Optional<InvestorDto> getInvestorById( String id) {
        return investorRepository.findById(id);
    }

    public InvestorDto createInvestor(InvestorDto investorDto) {
        return investorRepository.save(investorDto);
    }
}
