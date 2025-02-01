package com.francisco.resources.dtos;

import com.francisco.domain.Cliente;

public class CriarClienteDto {
    private String nome;
    private String email;
    private String cpfOuCnpj;

    public CriarClienteDto(String nome, String email, String cpfOuCnpj) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public Cliente toCliente() {
        return new Cliente(nome, email, cpfOuCnpj);
    }
}
