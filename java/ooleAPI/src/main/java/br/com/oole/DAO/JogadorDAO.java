package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.oole.models.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer>{
	
	@Transactional(readOnly = true)
	Jogador findByEmail(String email);
	
}
