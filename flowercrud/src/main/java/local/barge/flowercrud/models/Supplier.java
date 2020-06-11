package local.barge.flowercrud.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "suppliers")
public class Supplier {

//    (supplierid, name, address, phonenumber)

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long supplierid;

    private String name;
    private String address;
    private String phonenumber;

    @OneToMany(mappedBy = "supplier",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnoreProperties(value = "supplier")
    private List<Flower> flowers = new ArrayList<>();


    public Supplier() {
    }

    public Supplier(String name, String address, String phonenumber, List<Flower> flowers) {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenumber;
        this.flowers = flowers;
    }

    public long getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(long supplierid) {
        this.supplierid = supplierid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "supplierid=" + supplierid +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", flowers=" + flowers +
                '}';
    }
}
