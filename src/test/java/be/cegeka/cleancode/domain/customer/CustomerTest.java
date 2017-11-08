package be.cegeka.cleancode.domain.customer;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp() throws Exception {
        customer = new Customer("Verhoeven", "Vincent");
    }

    @Test
    public void equals_SameCustomer_isTrue() throws Exception {
        Assertions.assertThat(customer).isEqualTo(customer);
    }

    @Test
    public void equals_CustomerWithFirstNameAndLastName_isTrue() throws Exception {
        Assertions.assertThat(customer).isEqualTo(new Customer("Verhoeven", "Vincent"));
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(null);
    }

    @Test
    public void equals_ifOtherClass_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Object());
    }

    @Test
    public void equals_CustomerWithOtherLastName_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Customer("Willems", "Vincent"));
    }

    @Test
    public void equals_CustomerWithOtherFirstName_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Customer("Verhoeven", "Kiki"));
    }

    @Test
    public void equals_ObjectWithNullLastName_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Customer(null, "Vincent"));
    }

    @Test
    public void equals_ObjectWithBothNullLastName_isTrue() throws Exception {
        assertThat(new Customer(null, "Vincent")).isEqualTo(new Customer(null, "Vincent"));
    }

    @Test
    public void equals_ObjectWithNoNullLastName_isFalse() throws Exception {
        assertThat(new Customer(null, "Vincent")).isNotEqualTo(new Customer("Verhoeven", "Vincent"));
    }

    @Test
    public void equals_ObjectWithNullFirstName_isFalse() throws Exception {
        assertThat(customer).isNotEqualTo(new Customer("Verhoeven", null));
    }

    @Test
    public void equals_ObjectWithBothNullFirstName_isTrue() throws Exception {
        assertThat(new Customer("Verhoeven", null)).isEqualTo(new Customer("Verhoeven", null));
    }

    @Test
    public void equals_ObjectWithNoNullFirstName_isFalse() throws Exception {
        assertThat(new Customer("Verhoeven", null)).isNotEqualTo(new Customer("Verhoeven", "Vincent"));
    }

}