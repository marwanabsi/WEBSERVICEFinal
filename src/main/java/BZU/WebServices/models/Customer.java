package BZU.WebServices.models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private Date burnAt;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Ordere> orders;
}
