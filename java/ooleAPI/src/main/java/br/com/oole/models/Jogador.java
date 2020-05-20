package br.com.oole.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.oole.dto.JogadorDTO;
import br.com.oole.dto.OlheiroDTO;
import br.com.oole.models.enums.Perfil;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode(exclude = {"olheiros","jogadoresSeguidores","jogadoresSeguindo"})
public class Jogador implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String dataNascimento;
	
	private String urlFotoPerfil;
	
	private String cpf;
	private String sexo;
	private String posicao;
	private String problemaSaude;
	
	private String login;
	
	@JsonIgnore
	private String senha;
	
	@Column(unique=true)
	private String email;
	
	private String telefone;
	
	private Perfil perfil;
	
	private String nacionalidade;
	
	private String cep;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String endereco;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name = "observacoes")
	private Set<Olheiro> olheiros = new HashSet<Olheiro>();
	
	@ManyToMany
	@JsonIgnore
	@JoinTable(name = "JOGADOR_SEGUIDOR",
			joinColumns = @JoinColumn(name = "jogador_id"),
			inverseJoinColumns = @JoinColumn(name = "seguidor_id"))
	private Set<Jogador> jogadoresSeguindo = new HashSet<Jogador>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "jogadoresSeguindo")
	@JsonIgnore
	private Set<Jogador> jogadoresSeguidores = new HashSet<Jogador>();
	
	@OneToMany(mappedBy = "jogador")
	private List<Video> videos = new ArrayList<Video>();

	public Jogador(Integer id, String nome, String dataNascimento, String cpf, String sexo, String posicao,
			String problemaSaude, String login, String senha, String email, String telefone,
			String nacionalidade, String cep, String bairro, String cidade, String estado, String endereco) {
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
		this.perfil = Perfil.JOGADOR;
		this.nacionalidade = nacionalidade;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.endereco = endereco;
	}
	
	public List<OlheiroDTO> getObservadores(){
		List<OlheiroDTO> list = new ArrayList<OlheiroDTO>();
		for (Olheiro olheiro : this.olheiros) {
			list.add(Olheiro.toDTO(olheiro));
		}
		System.out.println(this.olheiros.size());
		return list;
	}
	
	public List<JogadorDTO> getSeguidores(){
		List<JogadorDTO> list = new ArrayList<JogadorDTO>();
		for (Jogador jogador : this.jogadoresSeguidores) {
			list.add(Jogador.toDTO(jogador));
		}
		return list;
	}
	
	public List<JogadorDTO> getSeguindo(){
		List<JogadorDTO> list = new ArrayList<JogadorDTO>();
		for (Jogador jogador : this.jogadoresSeguindo) {
			list.add(Jogador.toDTO(jogador));
		}
		return list;
	}
	
	public static JogadorDTO toDTO(Jogador j) {
		return new JogadorDTO(j.getId(),j.getUrlFotoPerfil(),j.getNome(),j.getDataNascimento(),j.getSexo(),j.getPosicao(),j.getProblemaSaude(),j.getLogin(),j.getEmail(),j.getTelefone(),j.getNacionalidade(),j.getEndereco(),j.getBairro(),j.getCidade(),j.getEstado());
	}
	
}
