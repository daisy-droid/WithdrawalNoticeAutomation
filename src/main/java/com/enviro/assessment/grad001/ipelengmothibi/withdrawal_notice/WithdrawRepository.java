package com.enviro.assessment.grad001.ipelengmothibi.withdrawal_notice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WithdrawRepository extends JpaRepository<WithdrawDto, String> {
}
