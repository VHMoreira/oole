package br.com.oole.dto;

public class UpdateJogadorDTO {
	private String login;
	private String posicao;
	private String problemaSaude;
	private String cep;
	private String endereco;
	private String email;
	private String telefone;
	
	public UpdateJogadorDTO(String login, String posicao, String problemSaude, String cep, String endereco,
			String email, String telefone) {
		super();
		this.login = login;
		this.posicao = posicao;
		this.problemaSaude = problemSaude;
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
