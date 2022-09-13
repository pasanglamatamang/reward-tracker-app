package reward.traker.app.controller;


import reward.traker.app.entity.CustomerEntity;
import reward.traker.app.services.CustomerService;
import reward.traker.app.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;

    @GetMapping
    public List<CustomerEntity> getAllCustomer() {
        return customerService.getCustomers();
    }

    @PostMapping
    public CustomerEntity addCustomer(@RequestBody CustomerEntity customer) {
        System.out.print(customer.toString());
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/totalrewards/{id}")
    public Map<String, Long> totalRewardsForCustomer(@PathVariable("id") Long id) {
        return transactionService.customerTotalReqardPoint(id);
    }

    @GetMapping("/monthly-reward/{id}")
    public List<Object> getMonthlyUserReward(@PathVariable("id") Long id) throws SQLException {
        return transactionService.rewardPointMonthBasis(id);
    }
}
