package br.com.oole.dto;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.oole.services.validation.InsertOlheiro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@InsertOlheiro
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class NewOlheiroDTO {
	
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
	private String nacionalidade;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String endereco;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	@Email(message = "Email invalido")
	private String email;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String telefone;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String cidade;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String estado;
}
