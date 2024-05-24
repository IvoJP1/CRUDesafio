package br.edu.fatecgru.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fatecgru.model.entity.Aluno;
import br.edu.fatecgru.model.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

	@Autowired
	
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<Aluno> listAll(){
		List<Aluno> alunos = alunoRepository.findAll();
		return alunos;
	}
	
	
	@GetMapping("/{id}")
	public Aluno getById(@PathVariable("id") Integer id) {
		Aluno aluno = alunoRepository.findById(id).get();
		return aluno;
	}
	
	@PostMapping
	public Aluno insert (@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	@PutMapping("/{id}")
	public Aluno update(@RequestBody Aluno aluno, @PathVariable Integer id) {
		// obter aluno
		Aluno alunoUpdate = alunoRepository.findById(id).get();
		// atualizar dados
		alunoUpdate.setNome(aluno.getNome());
		alunoUpdate.setEmail(aluno.getEmail());
		alunoUpdate.setEndereco(aluno.getEndereco());
		alunoUpdate.setDataNascimento(aluno.getDataNascimento());
		alunoUpdate.setPeriodo(aluno.getPeriodo());
		alunoRepository.save(alunoUpdate);
		return alunoUpdate;
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") Integer id){ 
		alunoRepository.deleteById(id);
		return "Aluno Exluido com Sucesso!";
		
	
	}
	@GetMapping("/nome/{nome}")
	public Aluno getByNome(@PathVariable String nome) {
		Aluno aluno = alunoRepository.findByNome(nome);
		return aluno;
		
	}
	@GetMapping("/primeiro-nome/{nome}")
	public List<Aluno> getByPrimeiroNome(@PathVariable String nome){
		List<Aluno> alunos = 
					alunoRepository.findByNomeStartsWith(nome);
		return alunos;
	}
}
