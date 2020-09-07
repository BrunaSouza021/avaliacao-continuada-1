package avaliacaocontinuada1.avaliacaocontinuada1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private List<Jogador> jogadores = new ArrayList<>();
    private List<Inimigo> inimigos = new ArrayList<>();


    @GetMapping("/jogadores")
    public ResponseEntity listarJogadores() {
        if(jogadores.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.ok(jogadores);
        }
    }

    @GetMapping("/inimigos")
    public ResponseEntity listarInimigos() {
        if(inimigos.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            return ResponseEntity.ok(inimigos);
        }
    }

    @PostMapping("/criarJogador")
    public ResponseEntity criarJogador (@RequestBody Jogador jogador) {
        jogadores.add(jogador);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/criarInimigo")
    public ResponseEntity criarInimigo (@RequestBody Inimigo inimigo) {
        inimigos.add(inimigo);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/concederExp/{id}/{exp}")
    public ResponseEntity concederExp (@PathVariable int id, @PathVariable int exp) {
        Jogador j = jogadores.get(id);

        if (j != null) {
            j.setExp(exp);
        }

        return ResponseEntity.ok(j);
    }

    @PostMapping("/causarDanoInimigo/{id}/{danoCausado}")
    public ResponseEntity causarDanoInimigo(@PathVariable int id, @PathVariable int danoCausado) {
        Inimigo i = inimigos.get(id);

        if (i != null) {
            i.setHp(i.getHp() - danoCausado);
        }

        return ResponseEntity.ok(i);
    }

    @PostMapping("/causarDanoJogador/{id}/{danoCausado}")
    public ResponseEntity causarDanoJogador(@PathVariable int id, @PathVariable int danoCausado) {
        Jogador j = jogadores.get(id);

        if (j != null) {
            j.setHp(j.getHp() - danoCausado);
        }

        return ResponseEntity.ok(j);
    }

    @DeleteMapping("/matarInimigo/{id}")
    public ResponseEntity matarInimigo (@PathVariable int id) {
        if(jogadores.size() >= id) {
            jogadores.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/matarJogador/{id}")
    public ResponseEntity matarJogador (@PathVariable int id) {
        if(jogadores.size() >= id) {
            jogadores.remove(id - 1);
            return ResponseEntity.ok().build();
        } else {
            return  ResponseEntity.status(404).build();
        }
    }
}
