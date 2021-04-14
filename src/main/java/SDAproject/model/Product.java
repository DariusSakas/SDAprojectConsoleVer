package SDAproject.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;
    private String name;
    private int quantity;
    private String description;
    private int price;
    private boolean wassent;
    private boolean wasdelivered;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
