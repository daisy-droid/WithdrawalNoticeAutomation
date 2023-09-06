package com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<BankDto, String> {
    Optional<BankDto> findByInvestorId(String investorId);
}
