package com.example.crud.funcionario;

public record FuncionarioResponseDTO(Long id, String nome, String cpf, String img, String email, String telefone, String endereco) {
    public FuncionarioResponseDTO(Funcionario funcionario){
        this(funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getImg(), funcionario.getEmail(), funcionario.getTelefone(), funcionario.getEndereco());
    }
}
