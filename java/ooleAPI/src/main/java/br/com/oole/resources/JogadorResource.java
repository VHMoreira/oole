package br.com.oole.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.oole.dto.JogadorDTO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.dto.UpdateJogadorDTO;
import br.com.oole.models.Endereco;
import br.com.oole.models.Jogador;
import br.com.oole.services.EnderecoService;
import br.com.oole.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private EnderecoService enderecoService;

	
	@GetMapping
	public ResponseEntity<List<Jogador>> findAll() {
		List<Jogador> list = jogadorService.findAll();  
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogador> find(@PathVariable Integer id) {
		System.out.println(id);
		Jogador obj = jogadorService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody NewJogadorDTO objDto) throws ParseException {
		Jogador obj = jogadorService.fromDTO(objDto);
		Endereco end = new Endereco(null, objDto.getCep(), objDto.getEndereco(), null, obj);
		
		obj = jogadorService.insert(obj);
		enderecoService.insert(end);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		Jogador jog = jogadorService.find(id);
		enderecoService.delete(jog.getEndereco().getId());
		jogadorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Jogador>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Jogador> list = jogadorService.findPage(page, linesPerPage, orderBy, direction); 
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UpdateJogadorDTO obj, @PathVariable Integer id) {
		jogadorService.update(obj, id);
		return ResponseEntity.noContent().build();
	}
}
