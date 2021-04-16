package br.com.zup.edu.propostas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/propostas")
public class PropostasController {

    private final EntityManager entityManager;

    PropostasController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<String> criaNovaProposta(@RequestBody CriacaoDeNovaPropostaRequest request, UriComponentsBuilder uriBuilder) {
        Proposta proposta = request.toModel();
        entityManager.persist(proposta);

        return ResponseEntity.created(uriBuilder.path("/propostas/{id}").buildAndExpand(proposta.getId()).toUri())
                .build();
    }
}
