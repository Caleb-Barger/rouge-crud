package local.barge.flowercrud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "flowers")
public class Flower {
//    (flowerid, type, price, supplierid)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long flowerid;

    private String type;
    private double price;

    @ManyToOne
    @JoinColumn(name = "supplierid",
            nullable = false)
    @JsonIgnoreProperties(value = "flowers")
    private Supplier supplier;

    public Flower() {

    }

    public Flower(String type, double price, Supplier supplier) {
        this.type = type;
        this.price = price;
        this.supplier = supplier;
    }

    public long getFlowerid() {
        return flowerid;
    }

    public void setFlowerid(long flowerid) {
        this.flowerid = flowerid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "flowerid=" + flowerid +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                '}';
    }
}
