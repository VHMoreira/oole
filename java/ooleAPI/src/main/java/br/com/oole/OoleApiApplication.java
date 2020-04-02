package br.com.oole;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.oole.DAO.EnderecoDAO;
import br.com.oole.DAO.JogadorDAO;
import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.models.Endereco;
import br.com.oole.models.Jogador;
import br.com.oole.models.Olheiro;

@SpringBootApplication
public class OoleApiApplication implements CommandLineRunner{
	
	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private OlheiroDAO olheiroDAO;
	
	@Autowired
	private EnderecoDAO enderecoDAO;

	public static void main(String[] args) {
		SpringApplication.run(OoleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
	}

}

