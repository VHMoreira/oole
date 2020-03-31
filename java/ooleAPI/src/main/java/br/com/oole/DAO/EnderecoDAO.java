package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oole.models.Endereco;

public interface EnderecoDAO extends JpaRepository<Endereco, Integer>{

}
