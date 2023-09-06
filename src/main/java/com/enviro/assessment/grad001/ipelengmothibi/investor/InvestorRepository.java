package com.enviro.assessment.grad001.ipelengmothibi.investor;

import org.springframework.data.jpa.repository.JpaRepository;

// Investor repository extends Jpa repository which have all the necessary functions required to perform CRUD functionality
public interface InvestorRepository extends JpaRepository<InvestorDto, String> {
}
