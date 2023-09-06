package com.enviro.assessment.grad001.ipelengmothibi.investor.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDto, String> {


}
