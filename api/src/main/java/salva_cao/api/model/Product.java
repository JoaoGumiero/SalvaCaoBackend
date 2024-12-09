package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String desc;

    @Column(nullable = false)
    private Float price;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private Image image_url;

    @Column(nullable = false)
    private Date register_date;

    @Column(nullable = false)
    private Boolean status;
}
