package br.com.oole.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.dto.UpdateJogadorDTO;
import br.com.oole.models.Jogador;
import br.com.oole.services.exceptions.DataIntegrityException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	public Jogador find(Integer id) {
		Optional<Jogador> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Jogador.class.getName()));
	}

	public Jogador insert(Jogador obj) {
		obj.setId(null);
		return dao.save(obj);
	}

	public Jogador update(UpdateJogadorDTO obj, Integer id) {
		Jogador newObj = find(id);
		updateData(newObj, obj);
		return dao.save(newObj);
	}

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

//	public Jogador fromDTO(NewJogadorDTO objDto) throws ParseException {
//		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
//		return new Jogador(null,objDto.getNome(), jdf.parse(objDto.getDataNascimento()), objDto.getCpf(), objDto.getSexo(), objDto.getPosicao(), objDto.getProblemaSaude(), "Jogador", '@'+objDto.getLogin(), objDto.getSenha());
//	}

	
	public Jogador fromDTO(NewJogadorDTO obj) throws ParseException {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		String senha = bc.encode(obj.getSenha());
		Date dataNascimento = jdf.parse(obj.getDataNascimento());
		return new Jogador(null,obj.getNome(), dataNascimento,obj.getCpf(),obj.getSexo(),obj.getPosicao(),obj.getProblemaSaude(), obj.getLogin(), senha,obj.getEmail(),obj.getTelefone(),null);
	}
//	
//	public Jogador fromDTO(UpdateJogadorDTO objDto) {
//		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
//		return new Jogador(null, n, jdf.parse(objDto.getDataNascimento()), null, objDto.getSexo(), objDto);
//	}

	private void updateData(Jogador newObj, UpdateJogadorDTO obj) {
		newObj.setLogin(obj.getLogin());
		newObj.setPosicao(obj.getPosicao());
		newObj.setProblemaSaude(obj.getProblemaSaude());
		newObj.getEndereco().setCep(obj.getCep());
		newObj.getEndereco().setEndereco(obj.getEndereco());
		newObj.setEmail(obj.getEmail());
		newObj.setTelefone(obj.getTelefone());
	}

}
