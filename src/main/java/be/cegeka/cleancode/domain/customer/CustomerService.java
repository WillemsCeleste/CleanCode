package be.cegeka.cleancode.domain.customer;

import be.cegeka.cleancode.LoyaltyCard;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

@Named
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public void addCustomer (String lastName, String firstName) {
        customerRepository.addCustomer(new Customer(lastName, firstName));
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    public void addLoyaltyCardToCustomer(int customerId, String barcode) {
        LoyaltyCard loyaltyCard = new LoyaltyCard(barcode);
        customerRepository.addLoyaltyCard(loyaltyCard);
        Customer customer = customerRepository.getCustomerById(customerId);
        customer.setLoyaltyCard(loyaltyCard);
    }
}
