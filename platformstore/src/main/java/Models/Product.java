package Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;
/*
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BucketUser bucketUser;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Favorites favorites;
 */
}