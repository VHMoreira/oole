package br.com.oole.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.oole.models.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer>{
	
	@Transactional(readOnly = true)
	Jogador findByEmail(String email);
	
	@Transactional(readOnly = true)
	@Query("Select distinct obj from Jogador obj where obj.login like %:login%")
	Page<Jogador> findAllByLogin(@Param("login") String login, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Jogador findByLogin(String login);
}
