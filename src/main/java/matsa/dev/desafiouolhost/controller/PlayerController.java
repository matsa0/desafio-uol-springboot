package matsa.dev.desafiouolhost.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import matsa.dev.desafiouolhost.model.Player;
import matsa.dev.desafiouolhost.model.dto.PlayerDTO;
import matsa.dev.desafiouolhost.service.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody @Valid PlayerDTO dto) {
        Player player = service.createPlayer(dto);

        //inclui o Player criado e retorna a resposta adequada HTTP 201 CREATED
        return new ResponseEntity<>(player, HttpStatus.CREATED); 
    }

    @GetMapping
    public ResponseEntity<List<Player>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> findById(@PathVariable Long id) {
        try {
            Player player = service.findById(id);
            return ResponseEntity.ok().body(player);
        }
        catch(NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }
}
