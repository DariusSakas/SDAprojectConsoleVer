package SDAproject.model;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Login {
    @PrimaryKeyJoinColumn(referencedColumnName = "email")
    String email;
    String pass;

}
