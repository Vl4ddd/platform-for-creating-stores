package Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bucketUser")
public class BucketUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "bucketId")
    private Long bucketId;

    @Column(name = "ProductId")
    private Long ProductId;

    @Column(name = "quantity")
    private int quantity;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Product product;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Bucket bucket;
}
