package matsa.dev.desafiouolhost.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerNotFoundException extends RuntimeException {
    
    private String msg;
    
    public PlayerNotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
