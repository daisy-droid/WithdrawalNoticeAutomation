package com.enviro.assessment.grad001.ipelengmothibi.product;

import com.enviro.assessment.grad001.ipelengmothibi.utilities.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
public class ProductDto extends Auditable<String> {
    @Id
    @GeneratedValue
    long id;

    @Enumerated(EnumType.STRING)
    @Column(name ="type")
    ProductType type;

    @NotBlank(message = "Product name is required")
    @Column(name ="name")
    String name;

    @NotNull(message = "Product balance is required")
    @Column(name ="current_balance")
    double currentBalance;

    @NotBlank(message = "Investor id is required")
    @Column(name ="investor_id")
    String investorId;
}
