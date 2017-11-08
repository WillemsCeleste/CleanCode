package be.cegeka.cleancode.domain;

import be.cegeka.cleancode.LoyaltyCard;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoyaltyCardTest {

    private LoyaltyCard loyaltyCard;

    @Before
    public void setUp() throws Exception {
        loyaltyCard = new LoyaltyCard("123456", 100);
    }

    @Test
    public void equals_SameCard_isTrue() throws Exception {
        Assertions.assertThat(loyaltyCard).isEqualTo(loyaltyCard);
    }

    @Test
    public void equals_CardWithSameBarcodeAndBonuspoints_isTrue() throws Exception {
        Assertions.assertThat(loyaltyCard).isEqualTo(new LoyaltyCard("123456", 100));
    }

    @Test
    public void equals_NullObject_isFalse() throws Exception {
        assertThat(loyaltyCard).isNotEqualTo(null);
    }

    @Test
    public void equals_ifOtherClass_isFalse() throws Exception {
        assertThat(loyaltyCard).isNotEqualTo(new Object());
    }

    @Test
    public void equals_CardWithOtherBarcode_isFalse() throws Exception {
        assertThat(loyaltyCard).isNotEqualTo(new LoyaltyCard("123457", 100));
    }

    @Test
    public void equals_CardWithOtherBonuspoints_isFalse() throws Exception {
        assertThat(loyaltyCard).isNotEqualTo(new LoyaltyCard("123456", 200));
    }

    @Test
    public void equals_ObjectWithNullBarcode_isFalse() throws Exception {
        assertThat(loyaltyCard).isNotEqualTo(new LoyaltyCard(null, 100));
    }

    @Test
    public void equals_ObjectWithBothNullBarcode_isTrue() throws Exception {
        assertThat(new LoyaltyCard(null, 100)).isEqualTo(new LoyaltyCard(null, 100));
    }

    @Test
    public void equals_ObjectWithNoNullBarcode_isFalse() throws Exception {
        assertThat(new LoyaltyCard(null, 100)).isNotEqualTo(new LoyaltyCard("123456", 100));
    }
}
