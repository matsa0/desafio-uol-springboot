package matsa.dev.desafiouolhost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import matsa.dev.desafiouolhost.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
