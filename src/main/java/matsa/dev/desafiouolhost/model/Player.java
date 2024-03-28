package matsa.dev.desafiouolhost.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import matsa.dev.desafiouolhost.model.dto.PlayerDTO;

@Entity
@Table(name = "players")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Player implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    private String phone;
    private String codename;
    private GroupType groupType;

    public Player() {
    }
    
    //Construtor que faz a conversão de um objeto PlayerDTO para Player
    public Player(PlayerDTO dto) {
        this.name = dto.name();
        this.email = dto.email();
        this.phone = dto.phone();
        this.groupType = dto.groupType();
    }
}
