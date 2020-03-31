package br.com.oole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.ContatoDAO;
import br.com.oole.models.Contato;
import br.com.oole.services.exceptions.DataIntegrityException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class ContatoService {
	@Autowired
	private ContatoDAO dao;

	public Contato find(Integer id) {
		Optional<Contato> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Contato.class.getName()));
	}

	public Contato insert(Contato obj) {
		obj.setId(null);
		return dao.save(obj);
	}

//	public Contato update(Contato obj) {
//		Contato newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return dao.save(newObj);
//	}

	public void delete(Integer id) {
		find(id);
		try {
			dao.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Contato que possui produtos");
		}
	}

	public List<Contato> findAll() {
		return dao.findAll();
	}

	public Page<Contato> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}

//	private void updateData(Contato newObj, Contato obj) {
//		newObj.setNome(obj.getNome());
//	}

}
