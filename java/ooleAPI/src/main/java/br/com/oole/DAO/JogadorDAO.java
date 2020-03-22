package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oole.models.Jogador;

public interface JogadorDAO extends JpaRepository<Jogador, Integer>{

}
