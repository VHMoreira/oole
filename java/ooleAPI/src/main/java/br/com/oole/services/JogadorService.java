package br.com.oole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.oole.dao.JogadorDAO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.dto.UpdateJogadorDTO;
import br.com.oole.models.Jogador;
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
		return dao.save(obj);
	}

	public List<Jogador> findAll() {
		return dao.findAll();
	}
	
	public void delete(Integer id) {
		Jogador obj = find(id);
		
		for (Jogador seguido : obj.getJogadoresSeguindo()) {
			seguido.getJogadoresSeguindo().remove(obj);
		}
		
		for (Jogador seguidor : obj.getJogadoresSeguidores()) {
			seguidor.getJogadoresSeguindo().remove(obj);
		}
		obj.getJogadoresSeguidores().clear();
		obj.getJogadoresSeguindo().clear();
		obj.getOlheiros().clear();
		dao.deleteById(id);
	}

	public Page<Jogador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}
	
	public Jogador follow(Integer seguidorId, Integer seguidoId) {
		Jogador seguidor = find(seguidorId);
		Jogador seguido = find(seguidoId);
		
		seguido.getJogadoresSeguidores().add(seguidor);
		return dao.save(seguido);
	}
	
	public Jogador unfollow(Integer seguidorId, Integer seguidoId) {
		Jogador seguidor = find(seguidorId);
		Jogador seguido = find(seguidoId);
		
		seguido.getJogadoresSeguidores().remove(seguidor);
		return dao.save(seguido);
	}

	public Jogador update(UpdateJogadorDTO obj, Integer id) {
		Jogador newObj = find(id);
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	private void updateData(Jogador newObj, UpdateJogadorDTO obj) {
		if(obj.getNome() != null) newObj.setNome(obj.getNome());
		if(obj.getLogin() != null) newObj.setLogin(obj.getLogin());
		
		if(obj.getPosicao() != null) newObj.setPosicao(obj.getPosicao());
		if(obj.getProblemaSaude() != null) newObj.setProblemaSaude(obj.getProblemaSaude());
		if(obj.getNacionalidade() != null) newObj.setNacionalidade(obj.getNacionalidade());
		
		if(obj.getCep() != null) newObj.setCep(obj.getCep());
		if(obj.getEndereco() != null) newObj.setEndereco(obj.getEndereco());
		if(obj.getBairro() != null) newObj.setBairro(obj.getBairro());
		if(obj.getCidade() != null) newObj.setCidade(obj.getCidade());
		if(obj.getEstado() != null) newObj.setEstado(obj.getEstado());
		
		if(obj.getEmail() != null) newObj.setEmail(obj.getEmail());
		if(obj.getTelefone() != null) newObj.setTelefone(obj.getTelefone());
	}

	public Jogador fromDTO(NewJogadorDTO objDto){
		String senha = bc.encode(objDto.getSenha());
		return new Jogador(null, objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), objDto.getSexo(), objDto.getPosicao(), objDto.getProblemaSaude(), '@'+objDto.getLogin(), senha, objDto.getEmail(), objDto.getTelefone(), objDto.getNacionalidade(),objDto.getCep(),objDto.getBairro(),objDto.getCidade(),objDto.getEstado(),objDto.getEndereco());
	}

}
