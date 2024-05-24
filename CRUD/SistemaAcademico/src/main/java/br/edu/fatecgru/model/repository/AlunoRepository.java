package br.edu.fatecgru.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fatecgru.model.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

	
	//pesquisar por nome
	Aluno findByNome(String nome);
	
	//lista de alunos pelo primeiro nome
	List<Aluno> findByNomeStartsWith(String nome);
	
}

	
	