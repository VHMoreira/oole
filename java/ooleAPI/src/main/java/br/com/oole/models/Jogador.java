package br.com.oole.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.oole.models.enums.Perfil;


@Entity
public class Jogador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Date dataNascimento;
	
	@JsonIgnore
	private String cpf;
	private String sexo;
	private String posicao;
	private String problemaSaude;
	
	@Column(unique = true)
	private String login;
	
	@JsonIgnore
	private String senha;
	
	@Column(unique=true)
	private String email;
	
	private String telefone;
	
	@OneToOne(mappedBy = "jogador")
	private Endereco endereco;
	
	@ManyToMany(mappedBy = "jogadores")
	private List<Olheiro> olheiros = new ArrayList<Olheiro>();

	@OneToMany(mappedBy = "jogador")
	private List<Video> videos = new ArrayList<Video>();
	
	private Perfil perfil;
	
	public Jogador() {
		super();
		this.perfil = Perfil.JOGADOR;
	}

	


	public Jogador(Integer id, String nome, Date dataNascimento, String cpf, String sexo, String posicao,
			String problemaSaude, String login, String senha, String email, String telefone,
			Endereco endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.sexo = sexo;
		this.posicao = posicao;
		this.problemaSaude = problemaSaude;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.perfil = Perfil.JOGADOR;
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
	
	
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
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
	
	
	public List<Olheiro> getOlheiros() {
		return olheiros;
	}

	public void setOlheiros(List<Olheiro> olheiros) {
		this.olheiros = olheiros;
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
	
	


	public List<Video> getVideos() {
		return videos;
	}


	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}


	public Perfil getPerfil() {
		return perfil;
	}




	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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
