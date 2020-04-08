package br.com.oole.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.oole.DAO.EnderecoDAO;
import br.com.oole.DAO.JogadorDAO;
import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.models.Endereco;
import br.com.oole.models.Jogador;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@Autowired
	private EnderecoDAO endDAO;
	
	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private OlheiroDAO olheiroDAO;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		Jogador j1 = new Jogador(null, "Juan Carvalho",jdf.parse("15/05/1999"),"47380312367","Masculino","Lateral Esquerdo", "", "juca", bc.encode("123456"), "juan@gmail.com", "91985374892", null);
		Endereco end1 = new Endereco(null,"66635110","Av. duque de caxias, n 458",null, null);
		
		j1.setEndereco(end1);
		endDAO.save(end1);
		end1.setJogador(j1);
		jogadorDAO.save(j1);
		endDAO.save(end1);
		
		return true;
	}
}
