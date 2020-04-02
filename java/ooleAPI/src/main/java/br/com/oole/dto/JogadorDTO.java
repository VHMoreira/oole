package br.com.oole.dto;

import java.io.Serializable;
import java.util.Set;

import br.com.oole.models.Jogador;

public class JogadorDTO implements Serializable{
	
	private String login;
	private String nome;
	private String dataNascimento;
	private String sexo;
	private String posicao;
	private String problemaSaude;
	
	private String cep;
	private String endereco;
	
	private String email;
	private String telefone;
	
	public JogadorDTO(Jogador obj) {
		super();
		this.login = obj.getLogin();
		this.nome = obj.getNome();
		this.dataNascimento = obj.getDataNascimento().toGMTString();
		this.sexo = obj.getSexo();
		this.posicao = obj.getPosicao();
		this.problemaSaude = obj.getProblemaSaude();
		this.cep = obj.getEndereco().getCep();
		this.endereco = obj.getEndereco().getEndereco();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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
