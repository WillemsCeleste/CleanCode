package be.cegeka.cleancode.domain.customer;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CustomerServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void addCustomer_ShouldCallCustomerRepository() throws Exception {
        customerService.addCustomer("Verhoeven", "Vincent");

        verify(customerRepository).addCustomer(new Customer("Verhoeven", "Vincent"));
    }

    @Test
    public void getAllCustomers_ShouldCallCustomerRepository() throws Exception {
        Customer jeroen = new Customer("Stroobants", "Jeroen");
        Customer len = new Customer("Karpisek", "Len");
        Customer nicky = new Customer("Dauchy", "Nicky");

        when(customerRepository.getAllCustomers()).thenReturn(Arrays.asList(jeroen, len, nicky));

        assertThat(customerService.getAllCustomers()).contains(jeroen, len, nicky);
    }
}