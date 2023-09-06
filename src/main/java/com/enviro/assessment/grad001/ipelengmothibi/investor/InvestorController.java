package com.enviro.assessment.grad001.ipelengmothibi.investor;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("investors")
public class InvestorController {
    @Autowired
    InvestorService investorService;

    //  Calling the get all investors function from the service class, getting the request params required for pagination
    //  Set the default values of the params in a case we don't receive them on the request
    @GetMapping("")
    public ResponseEntity<Page<InvestorDto>> getAllInvestors(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "50") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<InvestorDto> investors = investorService.getAllInvestors(pageable);

        return ResponseEntity.ok(investors);
    }

    //  Calling get an investor by id function from the service class and passing the id from the api path
    @GetMapping("/{id}")
    public ResponseEntity<Optional<InvestorDto>> getAllInvestors(@PathVariable String id) {
        return ResponseEntity.ok(investorService.getInvestorById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<InvestorDto> createInvestor(@RequestBody @Valid InvestorDto investorDto) {
        return new ResponseEntity<>(investorService.createInvestor(investorDto), HttpStatus.CREATED);
    }
}
