package br.com.oole.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.ContatoDAO;
import br.com.oole.DAO.EnderecoDAO;
import br.com.oole.DAO.JogadorDAO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.models.Endereco;
import br.com.oole.models.Jogador;
import br.com.oole.services.exceptions.DataIntegrityException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorDAO dao;
	
	@Autowired
	private EnderecoService endService;
	
	@Autowired
	private ContatoDAO contDao;

	public Jogador find(Integer id) {
		Optional<Jogador> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Jogador.class.getName()));
	}

	public Jogador insert(Jogador obj) {
		obj.setId(null);
		return dao.save(obj);
	}

//	public Jogador update(Jogador obj) {
//		Jogador newObj = find(obj.getId());
//		updateData(newObj, obj);
//		return dao.save(newObj);
//	}

	public void delete(Integer id) {
		find(id);
		try {
			dao.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma Jogador que possui produtos");
		}
	}

	public List<Jogador> findAll() {
		return dao.findAll();
	}

	public Page<Jogador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}

	public Jogador fromDTO(NewJogadorDTO objDto) throws ParseException {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		return new Jogador(null,objDto.getNome(), jdf.parse(objDto.getDataNascimento()), objDto.getCpf(), objDto.getSexo(), objDto.getPosicao(), objDto.getProblemaSaude(), "Jogador", objDto.getLogin(), objDto.getSenha());
	}

//	
//	public Jogador fromDTO(JogadorDTO objDto) {
//		return new Jogador(objDto.getId(), objDto.getNome());
//	}

//	private void updateData(Jogador newObj, Jogador obj) {
//		newObj.setNome(obj.getNome());
//	}

}
