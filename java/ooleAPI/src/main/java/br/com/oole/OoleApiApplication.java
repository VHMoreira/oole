package br.com.oole;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.models.Jogador;

@SpringBootApplication
public class OoleApiApplication implements CommandLineRunner{
	
	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private OlheiroDAO olheiroDAO;

	public static void main(String[] args) {
		SpringApplication.run(OoleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Jogador j1 = new Jogador(null, "Lucas Souza", jdf.parse("26/08/1999"), "039546212055", "Masculino", "Centroavante", null, "Jogador", "@lucastuna09", "123456");
		
		jogadorDAO.save(j1);
		
	}

}
