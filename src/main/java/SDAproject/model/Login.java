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
@Table(name = "LOGIN")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String nickname;
    private String pass;

}
