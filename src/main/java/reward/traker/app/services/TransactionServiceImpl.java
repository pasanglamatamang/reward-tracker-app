package reward.traker.app.services;

import reward.traker.app.entity.CustomerTransactionEntity;
import reward.traker.app.repository.TransactionRepository;
import reward.traker.app.util.RewardCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<CustomerTransactionEntity> getCustomerTransactions() {
        return transactionRepository.findAll();
    }


    @Override
    public CustomerTransactionEntity saveTransaction(CustomerTransactionEntity transaction) {
        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            LocalDateTime transactionDate = LocalDateTime.parse(String.valueOf(transaction.getTransactionDate()).replace("T", " "), formatter);
            transaction.setTransactionDate(transactionDate);
        }
        transaction.setRewardPerTransaction(RewardCalculator.calculateReward(transaction.getAmount()));
        return transactionRepository.save(transaction);
    }

    @Override
    public Map<String, Long> customerTotalReqardPoint(Long id) {
        Map<String, Long> totalReward = new HashMap<>();
        totalReward.put("customerId", id);
        totalReward.put("totalReward", transactionRepository.getTotalRewardPoints(id));

        return totalReward;
    }


    public List<Object> rewardPointMonthBasis(Long id) throws SQLException {
        return transactionRepository.getMonthlyRewards(id);

    }
}
