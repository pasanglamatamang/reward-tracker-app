package reward.traker.app.services;

import reward.traker.app.entity.CustomerEntity;


import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getCustomers();

    CustomerEntity saveCustomer(CustomerEntity customer);
    //Customer getCustomerById(Long id);

}
