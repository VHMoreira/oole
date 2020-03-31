package br.com.oole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.EnderecoDAO;
import br.com.oole.models.Endereco;
import br.com.oole.services.exceptions.DataIntegrityException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class EnderecoService {
	@Autowired
	private EnderecoDAO dao;

	public Endereco find(Integer id) {
		Optional<Endereco> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return dao.save(obj);
	}

//	public Endereco update(Endereco obj) {
//		Endereco newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return dao.save(newObj);
//	}

	public void delete(Integer id) {
		find(id);
		try {
			dao.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Endereco que possui produtos");
		}
	}

	public List<Endereco> findAll() {
		return dao.findAll();
	}

	public Page<Endereco> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}

//	private void updateData(Endereco newObj, Endereco obj) {
//		newObj.setNome(obj.getNome());
//	}

}
