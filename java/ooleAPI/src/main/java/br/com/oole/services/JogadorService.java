package br.com.oole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.models.Jogador;

@Service
public class JogadorService {
	@Autowired
	private JogadorDAO dao;
	
	public List<Jogador> findAll() {
		return dao.findAll();
	}
	
	public Jogador findById(Integer id) {
		Optional<Jogador> obj = dao.findById(id);
		return obj.orElse(null);
	}
}
