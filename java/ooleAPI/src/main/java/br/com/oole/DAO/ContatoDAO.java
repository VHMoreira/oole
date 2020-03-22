package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oole.models.Perfil;

public interface ContatoDAO extends JpaRepository<Perfil, Integer>{

}
