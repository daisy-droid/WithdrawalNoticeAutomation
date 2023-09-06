package com.enviro.assessment.grad001.ipelengmothibi.investor.address;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
public class AddressDto {

    @Id
    @GeneratedValue
    long id;

    @Column(name = "street")
    @NotBlank(message = "street is required")
    String street;

    @Column(name = "suburb")
    @NotBlank(message = "Suburb is required")
    String suburb;

    @Column(name = "city")
    @NotBlank(message = "City is required")
    String city;

    @Column(name = "country")
    @NotBlank(message = "Country is required")
    String country;

    @Column(name = "country_code")
    @NotBlank(message = "Country code is required")
    String countryCode;

    @Column(name = "zip_code")
    @NotBlank(message = "Zip code is required")
    String zipCode;
}
