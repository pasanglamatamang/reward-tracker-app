package reward.traker.app.repository;

import reward.traker.app.entity.CustomerTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface TransactionRepository extends JpaRepository<CustomerTransactionEntity, Long> {
    @Query(nativeQuery = true,
            value = "SELECT SUM(reward_per_transaction) " +
                    "FROM transaction t where t.customer_id= :id")
    Long getTotalRewardPoints(@Param("id") Long id);

    @Query(
            value = "SELECT new reward.traker.app.util.MonthlyRewardTrack(t.customer.id, " +
                    "SUM(t.rewardPerTransaction)," +
                    "MONTH(t.transactionDate), YEAR(t.transactionDate)) " +
                    " FROM CustomerTransactionEntity t" +
                    " WHERE t.customer.id = :id  GROUP BY MONTH(t.transactionDate) , YEAR(t.transactionDate) , t.customer.id")
    List<Object> getMonthlyRewards(@Param("id") Long id) throws SQLException;

}


