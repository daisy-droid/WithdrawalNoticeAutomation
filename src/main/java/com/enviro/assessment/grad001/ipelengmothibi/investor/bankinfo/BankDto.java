package com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_details")
@Getter
@Setter
public class BankDto {

    @Id
    @GeneratedValue
    long id;

    @NotBlank(message = "Investor id is required")
    @Column(name = "investor_id")
    String investorId;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_type")
    CardType cardType;

    @Enumerated(EnumType.STRING)
    @Column(name = "card_scheme")
    CardScheme cardScheme;

    @NotBlank
    @Column(name = "card_number")
    String cardNumber;

    @NotBlank
    @Column(name = "bank_name")
    String bankName;

    @NotBlank
    @Column(name = "bank_country")
    String bankCountry;
}
