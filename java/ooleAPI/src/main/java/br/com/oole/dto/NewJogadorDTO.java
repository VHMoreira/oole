package br.com.oole.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.oole.services.validation.InsertJogador;

@InsertJogador
public class NewJogadorDTO {
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max=50, message = "Deve ter no minimo dois caracteres")
	private String login;
	private String senha;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Length(min = 2, max=120, message = "Deve ter no minimo dois caracteres")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String dataNascimento;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String sexo;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String posicao;
	private String problemaSaude;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String endereco;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
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
