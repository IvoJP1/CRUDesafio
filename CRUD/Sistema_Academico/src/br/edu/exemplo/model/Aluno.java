package br.edu.exemplo.model;

public class Aluno {
	private int ra;
	private String nome;
	private String email;
	private String dataNascimento;
	private String endereco;
	private String periodo;
	
	public Aluno() {};
	
	public Aluno(int rA, String nome, String email, String dataDeNascimento, String endereco, String periodo) {
		super();
		ra = rA;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataDeNascimento;
		this.endereco = endereco;
		this.periodo = periodo;
	}
	public int getRa() {
		return ra;
	}
	public void setRa(int rA) {
		ra = rA;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataDeNascimento) {
		this.dataNascimento = dataDeNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	
}
