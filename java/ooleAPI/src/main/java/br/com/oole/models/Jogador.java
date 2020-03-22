package br.com.oole.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jogador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date dataNascimento;
	private String cpf;
	private String sexo;
	private String posicao;
	private String problemaSaude;
	private String tipo;
	private String login;
	private String senha;
	
	@OneToMany(mappedBy = "jogador")
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	@OneToMany(mappedBy = "jogador")
	private List<Contato> contatos = new ArrayList<Contato>();

	
	public Jogador() {
		super();
	}
	
	
	


	public Jogador(Integer id, String nome, Date dataNascimento, String cpf, String sexo, String posicao,
			String problemaSaude, String tipo, String login, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.posicao = posicao;
		this.problemaSaude = problemaSaude;
		this.tipo = tipo;
		this.login = login;
		this.senha = senha;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
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
	

	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public List<Contato> getContatos() {
		return contatos;
	}


	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}


	public String getTipo() {
		return tipo;
	}
	

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	

	// hashcode e equals criado baseado SOMENTE no id
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
