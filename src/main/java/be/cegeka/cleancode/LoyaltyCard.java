package be.cegeka.cleancode;


import javax.persistence.*;

@Entity
@Table(name = "LOYALTYCARD")
public class LoyaltyCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "BARCODE")
    private String barcode;
    @Column(name = "BONUSPOINTS")
    private int bonuspoints;

    public LoyaltyCard() {
    }

    public LoyaltyCard(String barcode, int bonuspoints) {
        this.barcode = barcode;
        this.bonuspoints = bonuspoints;
    }

    public LoyaltyCard(String barcode) {
        this.barcode = barcode;
    }

    public String getBarcode() {
        return barcode;
    }

    public int getBonuspoints() {
        return bonuspoints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoyaltyCard that = (LoyaltyCard) o;

        if (id != that.id) return false;
        if (bonuspoints != that.bonuspoints) return false;
        return barcode != null ? barcode.equals(that.barcode) : that.barcode == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (barcode != null ? barcode.hashCode() : 0);
        result = 31 * result + bonuspoints;
        return result;
    }
}
