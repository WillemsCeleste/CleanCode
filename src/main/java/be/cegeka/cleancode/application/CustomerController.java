package be.cegeka.cleancode.application;



import be.cegeka.cleancode.LoyaltyCard;
import be.cegeka.cleancode.domain.customer.Customer;
import be.cegeka.cleancode.domain.customer.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/customer")
@Transactional
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @PostMapping
    public void addCustomer (
           @RequestParam(value = "lastName", required = true) String lastName,
           @RequestParam(value = "firstName", required = true) String firstName) {
        customerService.addCustomer(lastName, firstName);
    }

    @PostMapping(path = "/addloyaltycard")
    public void addLoyaltyCardToCustomer(
            @RequestParam(value = "customer_id", required = true) int id,
            @RequestParam(value = "barcode", required = true) String barcode) {
        customerService.addLoyaltyCardToCustomer(id, barcode);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }



}
