package com.example.crud.funcionario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="funcionarios")
@Entity(name="funcionarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Funcionario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String img;
    private String cpf;
    private String email;
    private String telefone;
    private String endereco;

    public Funcionario(FuncionarioRequestDTO data){
        this.nome = data.nome();
        this.img = data.img();
        this.cpf = data.cpf();
        this.email = data.email();
        this.telefone = data.telefone();
        this.endereco = data.endereco();
    }
}
