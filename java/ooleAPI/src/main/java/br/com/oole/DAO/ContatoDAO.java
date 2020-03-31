package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oole.models.Contato;

public interface ContatoDAO extends JpaRepository<Contato, Integer>{

}
