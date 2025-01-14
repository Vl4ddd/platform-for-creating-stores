package platform.platformstore.Models;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProductDTO {
    private String title;
    private String description;
    private BigDecimal price;
    private Integer stock;
}