package be.cegeka.cleancode.domain.customer;

import be.cegeka.cleancode.LoyaltyCard;
import be.cegeka.cleancode.domain.customer.Customer;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Named
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addCustomer (Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomers() {
        return entityManager.createQuery("select c from Customer c", Customer.class).getResultList();
    }

    public Customer getCustomerByLoyaltyCard (String barcode) {
        return null;
    }

    public void addLoyaltyCard (LoyaltyCard loyaltyCard) {
        entityManager.persist(loyaltyCard);
    }

    public Customer getCustomerById(int customerId) {
        return entityManager.find(Customer.class, customerId);
    }
}
