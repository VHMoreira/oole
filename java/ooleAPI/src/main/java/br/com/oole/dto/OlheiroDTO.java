package br.com.oole.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
public class OlheiroDTO {
	private Integer id;
	private String urlFotoPerfil;
	private String nome;
	private String dataNascimento;
	
	private String sexo;
	
	private String login;
	
	private String email;
	
	private String telefone;
	
	private String nacionalidade;
	
	private String cep;
	
	private String bairro;
	
	private String cidade;
	
	private String endereco;
	
	private String estado;
}
