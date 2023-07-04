package BZU.WebServices.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "ordere")
public class Ordere {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "ordere", cascade = CascadeType.ALL)
    private List<ProductOrder> productOrders;

    private Date orderAt;
}
