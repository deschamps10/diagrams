package br.com.senai.sa3semestre.projeto_efluentes.controllers;

import br.com.senai.sa3semestre.projeto_efluentes.entities.Amostra;
import br.com.senai.sa3semestre.projeto_efluentes.repositories.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/amostras")
public class AmostraController {

    @Autowired
    private AmostraRepository amostraRepository;


    @GetMapping
    public ResponseEntity<List<Amostra>> getAllAmostras() {
        List<Amostra> listaDeTodasAmostras = amostraRepository.findAll();
        return ResponseEntity.ok(listaDeTodasAmostras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Amostra> getAmostraById(@PathVariable Long id) {
        Optional<Amostra> amostraOptional = amostraRepository.findById(id);
        return amostraOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Amostra> createAmostra(@RequestBody Amostra amostraParaCriar) {
        Amostra amostraSalvaNoBanco = amostraRepository.save(amostraParaCriar);
        return ResponseEntity.status(HttpStatus.CREATED).body(amostraSalvaNoBanco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Amostra> updateAmostra(@PathVariable Long id,
                                                 @RequestBody Amostra amostraAtualizada) {
        if (!amostraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        amostraAtualizada.setIdAmostra(id);
        Amostra amostraSalvaNoBanco = amostraRepository.save(amostraAtualizada);
        return ResponseEntity.ok(amostraSalvaNoBanco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmostra(@PathVariable Long id) {
        if (!amostraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        amostraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
