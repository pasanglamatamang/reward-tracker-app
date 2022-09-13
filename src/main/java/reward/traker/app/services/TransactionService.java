package reward.traker.app.services;

import reward.traker.app.entity.CustomerTransactionEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface TransactionService {
    List<CustomerTransactionEntity> getCustomerTransactions();

    CustomerTransactionEntity saveTransaction(CustomerTransactionEntity transaction);


    Map<String, Long> customerTotalReqardPoint(Long id);
    List<Object> rewardPointMonthBasis(Long id) throws SQLException;
}
