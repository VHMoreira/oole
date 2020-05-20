package br.com.oole.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class JogadorDTO {
	private Integer id;
	private String urlFotoPerfil;
	private String nome;
	private String dataNascimento;

	private String sexo;
	private String posicao;
	private String problemaSaude;
	
	private String login;
	private String email;
	
	private String telefone;

	private String nacionalidade;
	
	private String endereco;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
}
