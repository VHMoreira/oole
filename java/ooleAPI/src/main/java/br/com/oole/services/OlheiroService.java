package br.com.oole.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.oole.dao.OlheiroDAO;
import br.com.oole.dto.NewOlheiroDTO;
import br.com.oole.dto.OlheiroDTO;
import br.com.oole.models.Jogador;
import br.com.oole.models.Olheiro;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class OlheiroService {
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private OlheiroDAO dao;
	
//	@Autowired
//	private BCryptPasswordEncoder bc;
	
	public Olheiro find(Integer id) {
		Optional<Olheiro> obj = dao.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Olheiro.class.getName()));
	}

	public Olheiro insert(Olheiro obj) {
		return dao.save(obj);
	}

	public List<Olheiro> findAll() {
		return dao.findAll();
	}

	public Page<Olheiro> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAll(pageRequest);
	}
	
	public Olheiro follow(Integer seguidorId, Integer seguidoId) {
		Olheiro seguidor = find(seguidorId);
		Olheiro seguido = find(seguidoId);
		
		seguido.getOlheirosSeguidores().add(seguidor);
		return dao.save(seguido);
	}
	
	public Olheiro observe(Integer olheiroId, Integer jogadorId) {
		Jogador jogador = jogadorService.find(jogadorId);
		Olheiro olheiro = find(olheiroId);
		
		olheiro.getJogadores().add(jogador);
		jogador.getOlheiros().add(olheiro);
		
		return dao.save(olheiro);
	}
	
	public Olheiro update(OlheiroDTO obj, Integer id) {
		Olheiro newObj = find(id);
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	private void updateData(Olheiro newObj, OlheiroDTO obj) {
		if(obj.getNome() != null) newObj.setNome(obj.getNome());
		if(obj.getLogin() != null) newObj.setLogin(obj.getLogin());
		
		if(obj.getNacionalidade() != null) newObj.setNacionalidade(obj.getNacionalidade());
		
		if(obj.getCep() != null) newObj.setCep(obj.getCep());
		if(obj.getEndereco() != null) newObj.setEndereco(obj.getEndereco());
		if(obj.getBairro() != null) newObj.setBairro(obj.getBairro());
		if(obj.getCidade() != null) newObj.setCidade(obj.getCidade());
		if(obj.getEstado() != null) newObj.setEstado(obj.getEstado());
		
		if(obj.getEmail() != null) newObj.setEmail(obj.getEmail());
		if(obj.getTelefone() != null) newObj.setTelefone(obj.getTelefone());
	}

	public Olheiro fromDTO(NewOlheiroDTO objDto){
		return new Olheiro(null,objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), objDto.getSexo(), '@'+objDto.getLogin(), objDto.getSenha(), objDto.getEmail(), objDto.getTelefone(), objDto.getNacionalidade(),objDto.getCep(),objDto.getBairro(),objDto.getCidade(),objDto.getEstado(),objDto.getEndereco());
	}

}
