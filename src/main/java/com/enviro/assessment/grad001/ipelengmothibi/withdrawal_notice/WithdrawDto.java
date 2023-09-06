package com.enviro.assessment.grad001.ipelengmothibi.withdrawal_notice;

import com.enviro.assessment.grad001.ipelengmothibi.investor.InvestorDto;
import com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo.BankDto;
import com.enviro.assessment.grad001.ipelengmothibi.product.ProductDto;
import com.enviro.assessment.grad001.ipelengmothibi.utilities.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "withdrawal_notice")
@Setter
@Getter
public class WithdrawDto extends Auditable<String> {

    @Id
    @GeneratedValue
    long id;


    @NotNull(message = "amount is required")
    @Column(name = "withdraw_amount")
    double withdrawAmount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_details", referencedColumnName = "id")
    BankDto bankDetails;

    @Column(name = "investor_id")
    String investorId;

    @Column(name = "product_id")
    String productId;
}
