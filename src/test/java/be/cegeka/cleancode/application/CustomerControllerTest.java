package be.cegeka.cleancode.application;

import be.cegeka.cleancode.domain.customer.CustomerService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class CustomerControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Test
    public void whenAddCustomer_ShouldCallCustomerService() throws Exception {
        customerController.addCustomer("Verhoeven", "Vincent");

        verify(customerService).addCustomer("Verhoeven", "Vincent");
    }

    @Test
    public void whenGetAllCustomers_ShouldCallCustomerService() throws Exception {
        customerController.getAllCustomers();

        verify(customerService).getAllCustomers();
    }
}