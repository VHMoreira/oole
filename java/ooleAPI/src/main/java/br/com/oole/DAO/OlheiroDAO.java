package br.com.oole.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.oole.models.Olheiro;

public interface OlheiroDAO extends JpaRepository<Olheiro, Integer>{
	
	@Transactional(readOnly = true)
	Olheiro findByEmail(String email);
	
	@Transactional(readOnly = true)
	@Query("Select distinct obj from Olheiro obj where obj.login like %:login%")
	Page<Olheiro> findAllByLogin(@Param("login") String login, Pageable pageRequest);
	
	@Transactional(readOnly = true)
	Olheiro findByLogin(String login);
}
