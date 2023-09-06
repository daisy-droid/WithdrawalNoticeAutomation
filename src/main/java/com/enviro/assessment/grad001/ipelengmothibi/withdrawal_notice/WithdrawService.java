package com.enviro.assessment.grad001.ipelengmothibi.withdrawal_notice;

import com.enviro.assessment.grad001.ipelengmothibi.investor.InvestorDto;
import com.enviro.assessment.grad001.ipelengmothibi.investor.InvestorRepository;
import com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo.BankDto;
import com.enviro.assessment.grad001.ipelengmothibi.investor.bankinfo.BankRepository;
import com.enviro.assessment.grad001.ipelengmothibi.product.ProductDto;
import com.enviro.assessment.grad001.ipelengmothibi.product.ProductRepository;
import com.enviro.assessment.grad001.ipelengmothibi.product.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WithdrawService {

    @Autowired
    WithdrawRepository withdrawRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    InvestorRepository investorRepository;

    @Autowired
    BankRepository bankRepository;

    public String withdraw(WithdrawDto withdrawDto) {
        Optional<ProductDto> productDto = productRepository.findById(withdrawDto.productId);
        Optional<InvestorDto> investorDto = investorRepository.findById(withdrawDto.investorId);
        Optional<BankDto> bankDto = bankRepository.findByInvestorId(withdrawDto.investorId);

        WithdrawDto tempWithdraw = new WithdrawDto();
        ProductDto tempProduct = new ProductDto();

        double limitAmount = productDto.map(dto -> calculateNinetyPercent(dto.getCurrentBalance())).orElse(0.0);
        double balance = productDto.map(this::getProductBalance).orElse(0.0);

        double remaining = remainingAmount(balance, limitAmount);

        if(productDto.isPresent() && withdrawDto.withdrawAmount >
                getProductBalance(productDto.get())) return "Sorry, you cannot withdraw the amount more than your " +
                "product current balance";

        if(withdrawDto.withdrawAmount > limitAmount) return "Sorry, you cannot withdraw the amount more than: " + limitAmount;


        if(productDto.isPresent()) {
            if (isRetirement(productDto.get().getType())) {
                if (investorDto.isPresent() && isAbove65(investorDto.get())) {


                    tempWithdraw.setWithdrawAmount(withdrawDto.getWithdrawAmount());
                    bankDto.ifPresent(tempWithdraw::setBankDetails);
                    tempWithdraw.setProductId(withdrawDto.productId);
                    tempWithdraw.setInvestorId(withdrawDto.investorId);

                    withdrawRepository.save(tempWithdraw);

                    tempProduct.setId(productDto.get().getId());
                    tempProduct.setCurrentBalance(remaining);
                    productRepository.save(tempProduct);

                    return responseMessage(productDto.get().getName(), balance, limitAmount, remaining);
                } else {
                    return "You are not eligible to withdraw your retirement founds at your age: ";
                }
            } else {
                tempWithdraw.setWithdrawAmount(withdrawDto.getWithdrawAmount());
                bankDto.ifPresent(tempWithdraw::setBankDetails);
                tempWithdraw.setProductId(withdrawDto.productId);
                tempWithdraw.setInvestorId(withdrawDto.investorId);

                withdrawRepository.save(tempWithdraw);

                tempProduct.setId(productDto.get().getId());
                tempProduct.setCurrentBalance(remaining);
                productRepository.save(tempProduct);
                return responseMessage(productDto.get().getName(), balance, limitAmount, remaining);
            }

        } else {
            return "Could not retrieve product information";
        }
    }

    private String responseMessage(String name, double balance, double limitAmount, double remaining) {
        return "You have successfully withdrawn \n " + name +
                "Balance before: \t " + balance + "\n" +
                "Withdrawn: \t " + limitAmount + "\n" +
                "Closing Balance: \t " + remaining + "\n";
    }
    private double getProductBalance(ProductDto productDto) {
        return productDto.getCurrentBalance();
    }

    private boolean isRetirement(ProductType type) {
        return type.equals(ProductType.RETIREMENT);
    }

    private boolean isAbove65(InvestorDto investorDto) {
        return investorDto.getAge() > 65;
    }
    private double calculateNinetyPercent(double amount) {
       return amount * 90 / 100;
    }

    private double remainingAmount(double productBal, double limitAmnt) {
        return productBal - limitAmnt;
    }

}
