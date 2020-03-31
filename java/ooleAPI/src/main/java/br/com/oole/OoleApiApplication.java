package br.com.oole;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.oole.DAO.ContatoDAO;
import br.com.oole.DAO.EnderecoDAO;
import br.com.oole.DAO.JogadorDAO;
import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.models.Contato;
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
	
	@Autowired
	private ContatoDAO contatoDAO;

	public static void main(String[] args) {
		SpringApplication.run(OoleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Jogador j1 = new Jogador(null, "Lucas Sagres", jdf.parse("26/08/1999"), "039546212055", "Masculino", "Centroavante", null, "Jogador", "@lucastuna09", "123456");
		Contato c1 = new Contato(null, "lucasSagres@gmail.com", "985471230", j1, null);
		Endereco e1 = new Endereco(null, "635100951", "Av Senador Lemos, N 5001", null, j1);
		j1.getEnderecos().add(e1);
		j1.getContatos().add(c1);
		
		jogadorDAO.saveAll(Arrays.asList(j1));
		enderecoDAO.save(e1);
		contatoDAO.save(c1);
		
		Olheiro o1 = new Olheiro(null, "Jorge Caio", jdf.parse("26/08/1987"), "039546215248", "Masculino", "Olheiro", "@jorgecaio", "987654321");
		Contato c2 = new Contato(null, "jorgecaio@gmail.com", "985471230", null, o1);
		Endereco e2 = new Endereco(null, "635100951", "Conj. Cidade Nova 1, WE-10, N 418", o1, null);
		o1.getEnderecos().add(e2);
		o1.getContatos().add(c2);
		o1.getJogadores().add(j1);
		j1.getOlheiros().add(o1);
		
		
		olheiroDAO.save(o1);
		enderecoDAO.save(e2);
		contatoDAO.save(c2);
	}

}

