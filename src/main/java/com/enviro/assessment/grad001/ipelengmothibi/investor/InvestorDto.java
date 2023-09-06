package com.enviro.assessment.grad001.ipelengmothibi.investor;

import com.enviro.assessment.grad001.ipelengmothibi.investor.address.AddressDto;
import com.enviro.assessment.grad001.ipelengmothibi.utilities.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

// lombok getter and setter annotations helps with creating the getters and setters methods in the class
@Entity
@Table(name = "investor")
@Getter
@Setter
public class InvestorDto extends Auditable<String> {
    @Id
    @GeneratedValue
    long id;

    @NotBlank(message = "Investor name is required")
    @Column(name ="name")
    String name;

    @NotBlank(message = "Investor surname is required")
    @Column(name ="surname")
    String surname;

    @NotNull(message = "Age is required")
    @Column(name ="age")
    int age;

    @Email
    @Column(name ="email", unique = true)
    String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="address", referencedColumnName = "id")
    AddressDto address;

    @NotBlank(message = "investor phone number is required")
    @Column(name ="phone_number", unique = true)
    String phoneNumber;
}
