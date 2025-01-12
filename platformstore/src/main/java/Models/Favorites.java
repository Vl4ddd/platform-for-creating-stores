package Models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userId")
    private Long userId;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private BucketUser bucketUser;
}
