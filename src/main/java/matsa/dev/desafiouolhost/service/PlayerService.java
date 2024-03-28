package matsa.dev.desafiouolhost.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matsa.dev.desafiouolhost.exception.PlayerNotFoundException;
import matsa.dev.desafiouolhost.infra.CodenameHandler;
import matsa.dev.desafiouolhost.model.GroupType;
import matsa.dev.desafiouolhost.model.Player;
import matsa.dev.desafiouolhost.model.dto.PlayerDTO;
import matsa.dev.desafiouolhost.repository.PlayerRepository;

@Service
public class PlayerService {
    
    @Autowired
    private PlayerRepository repository;

    @Autowired
    private CodenameHandler handler;

    public Player createPlayer(PlayerDTO dto) {
        //chama a classe que converte data(dto) para objeto(player)
        Player player = new Player(dto);
        String codename = getCodename(dto.groupType());
        player.setCodename(codename);

        return repository.save(player);
    }

    private String getCodename(GroupType groupType) {
        return handler.findCodename(groupType);
    }

    public List<Player> findAll() {
        List<Player> list = repository.findAll();

        return list;
    }

    @SuppressWarnings("null")
    public Player findById(Long id) {
        Optional<Player> player = repository.findById(id);

        return player.orElseThrow(() -> new PlayerNotFoundException("Player not found in id: " + id));
    }
}
