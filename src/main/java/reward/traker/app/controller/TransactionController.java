package reward.traker.app.controller;

import reward.traker.app.entity.CustomerTransactionEntity;
import reward.traker.app.services.CustomerServiceImpl;
import reward.traker.app.services.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
    @Autowired
    TransactionServiceImpl customerTransactionImpl;

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping
    public List<CustomerTransactionEntity> getAllTransaction() {
        return customerTransactionImpl.getCustomerTransactions();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE )
    public CustomerTransactionEntity saveTransaction(@RequestBody CustomerTransactionEntity transaction) {
        transaction.setCustomer(customerService.getCustomer(transaction.getCustomer().getId()));
        return customerTransactionImpl.saveTransaction(transaction);
    }

}
