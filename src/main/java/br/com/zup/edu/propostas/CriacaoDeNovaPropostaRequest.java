package br.com.zup.edu.propostas;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

class CriacaoDeNovaPropostaRequest {

    @JsonProperty
    private final String documento;

    @JsonProperty
    private final String email;

    @JsonProperty
    private final String nome;

    @JsonProperty
    private final String endereco;

    @JsonProperty
    private final BigDecimal salario;

    CriacaoDeNovaPropostaRequest(String documento, String email, String nome, String endereco, BigDecimal salario) {
        this.documento = documento;
        this.email = email;
        this.nome = nome;
        this.endereco = endereco;
        this.salario = salario;
    }

    Proposta toModel() {
        return new Proposta(documento, email, nome, endereco, salario);
    }
}
