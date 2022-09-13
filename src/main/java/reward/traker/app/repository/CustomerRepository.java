package reward.traker.app.repository;

import reward.traker.app.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
