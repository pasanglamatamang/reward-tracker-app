package reward.traker.app.services;

import reward.traker.app.entity.CustomerEntity;
import reward.traker.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<CustomerEntity> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerEntity saveCustomer(CustomerEntity customer) {
        customer.setJoinedDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }


    public CustomerEntity getCustomer(Long id) {
        return customerRepository.getById(id);
    }



}
