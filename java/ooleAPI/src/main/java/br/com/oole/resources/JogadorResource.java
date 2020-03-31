package br.com.oole.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.models.Contato;
import br.com.oole.models.Endereco;
import br.com.oole.models.Jogador;
import br.com.oole.services.ContatoService;
import br.com.oole.services.EnderecoService;
import br.com.oole.services.JogadorService;

@RestController(value = "/jogador")
public class JogadorResource {
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Autowired
	private ContatoService contatoService;
	
	@GetMapping
	public ResponseEntity<List<Jogador>> findAll() {
		return ResponseEntity.ok(jogadorService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogador> find(@PathVariable Integer id) {
		Jogador obj = jogadorService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewJogadorDTO objDto) throws ParseException {
		Jogador obj = jogadorService.fromDTO(objDto);
		Endereco end = new Endereco(null, objDto.getCep(), objDto.getEndereco(), null, obj);
		Contato cont = new Contato(null, objDto.getEmail(), objDto.getTelefone(), obj, null);
		
		obj.getEnderecos().add(end);
		obj.getContatos().add(cont);
		
		obj = jogadorService.insert(obj);
		enderecoService.insert(end);
		contatoService.insert(cont);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
