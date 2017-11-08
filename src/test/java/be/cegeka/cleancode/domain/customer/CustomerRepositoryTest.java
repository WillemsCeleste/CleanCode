package be.cegeka.cleancode.domain.customer;

import be.cegeka.cleancode.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class CustomerRepositoryTest {

    @Inject
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Customer vincent, nelson, momo;

    @Before
    public void setUp() throws Exception {
        vincent = new Customer("Verhoeven", "Vincent");
        nelson = new Customer("Dekat", "Nelson");
        momo = new Customer("Mompeltje", "Momo");

        entityManager.persist(vincent);
        entityManager.persist(nelson);
        entityManager.persist(momo);
    }

    @Test
    public void getAllCustomers_ShouldReturnAllCustomers() throws Exception {
        List<Customer> customers = customerRepository.getAllCustomers();

        Assertions.assertThat(customers).contains(vincent, nelson, momo);
    }

    @Test
    public void checkAddCustomers() throws Exception {
        Customer kiki = new Customer("Willems", "Kiki");
        customerRepository.addCustomer(kiki);
        List<Customer> customers = customerRepository.getAllCustomers();
        Assertions.assertThat(customers).contains(vincent, nelson, momo, kiki);
    }
}