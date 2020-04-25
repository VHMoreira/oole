package br.com.oole.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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

import br.com.oole.dto.NewOlheiroDTO;
import br.com.oole.dto.OlheiroDTO;
import br.com.oole.models.Olheiro;
import br.com.oole.services.OlheiroService;

@RestController
@RequestMapping(value = "/olheiros")
public class OlheiroResource {
	
	@Autowired
	private OlheiroService olheiroService;

	
	@GetMapping
	public ResponseEntity<List<Olheiro>> findAll() {
		List<Olheiro> list = olheiroService.findAll();  
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Olheiro> find(@PathVariable Integer id) {
		Olheiro obj = olheiroService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody NewOlheiroDTO objDto) throws ParseException {
		Olheiro obj = olheiroService.fromDTO(objDto);
		obj = olheiroService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Olheiro>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Olheiro> list = olheiroService.findPage(page, linesPerPage, orderBy, direction); 
		return ResponseEntity.ok().body(list);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody OlheiroDTO obj, @PathVariable Integer id) {
		olheiroService.update(obj, id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{seguidorId}/seguir/{seguidoId}")
	public ResponseEntity<Void> follow(@PathVariable Integer seguidorId, @PathVariable Integer seguidoId) {
		olheiroService.follow(seguidorId, seguidoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{olheiroId}/observar/{jogadorId}")
	public ResponseEntity<Void> observe(@PathVariable Integer olheiroId, @PathVariable Integer jogadorId) {
		olheiroService.observe(olheiroId, jogadorId);
		return ResponseEntity.noContent().build();
	}
}
