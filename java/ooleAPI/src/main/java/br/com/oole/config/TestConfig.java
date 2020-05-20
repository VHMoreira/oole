package br.com.oole.config;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.models.Jogador;
import br.com.oole.models.Olheiro;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	
	@Autowired
	private JogadorDAO jogadorDAO;
	
	@Autowired
	private OlheiroDAO olheiroDAO;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		Jogador j1 = new Jogador(null,"José","20/11/2001","97106015040","Masculino","Centroavante","","jsoe",bc.encode("123456"),"jose@gmail.com","91985397070", "Brasileiro","66635110","Parque Verde","Belém","Pará","Rod.Augusto Montenegro 5955");
		Jogador j2 = new Jogador(null,"Marcio","31/12/1999","97106015040","Masculino","Goleiro","Asma","Marcio","123456","Marcio@gmail.com","91985397070","Brasileiro","66635110","Parque Verde","Belém","Pará","Rod.Augusto Montenegro 5955");
		Jogador j3 = new Jogador(null,"Luana","20/11/2001","97106015040","Feminino","Zagueira","","Luana","123456","Luana@gmail.com","91985397070", "Brasileiro","66635110","Parque Verde","Belém","Pará","Rod.Augusto Montenegro 5955");
		
		
		jogadorDAO.saveAll(Arrays.asList(j1,j2,j3));
		
		
		Olheiro o1 = new Olheiro(null,"Raimundo","18/05/1969","65434460057","Masculino","rai","456123","rai@gmail.com","32154878", "Brasileiro","66635110","Parque Verde","Belém","Pará","Rod.Augusto Montenegro 5955");
		Olheiro o2 = new Olheiro(null,"Cassio","18/05/1969","65434460050","Masculino","csi",bc.encode("123456"),"caasio@gmail.com","32154878", "Brasileiro","76435510","Centro","São Paulo","São Paulo","Avenida Paulista");
				
		
		olheiroDAO.save(o1);
		olheiroDAO.save(o2);
		return true;
	}
}
