package br.com.oole.dto;

import java.util.Date;

public class NewJogadorDTO {
	
	private String login;
	private String senha;
	
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String sexo;
	private String posicao;
	private String problemaSaude;
	
	private String cep;
	private String endereco;
	
	private String email;
	private String telefone;
	
	
	
	public NewJogadorDTO(String login, String senha, String nome, String dataNascimento, String cpf, String sexo,
			String posicao, String problemaSaude, String cep, String endereco, String email, String telefone) {
		super();
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.posicao = posicao;
		this.problemaSaude = problemaSaude;
		this.cep = cep;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPosicao() {
		return posicao;
	}
	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getProblemaSaude() {
		return problemaSaude;
	}
	public void setProblemaSaude(String problemaSaude) {
		this.problemaSaude = problemaSaude;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
