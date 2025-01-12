package Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FavoritesUser")
public class FavoritesUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "favoritesId")
    private Long favoritesId;

    @Column(name = "ProductId")
    private Long ProductId;

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Product product;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private Favorites favorites;
}
