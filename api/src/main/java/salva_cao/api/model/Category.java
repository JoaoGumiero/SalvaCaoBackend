package salva_cao.api.model;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "Category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String desc;
}
