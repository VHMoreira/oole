package br.com.oole.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.oole.models.Olheiro;

public interface OlheiroDAO extends JpaRepository<Olheiro, Integer>{
	
	@Transactional(readOnly = true)
	Olheiro findByEmail(String email);
	
	@Transactional(readOnly = true)
	Olheiro findByLogin(String login);
}
