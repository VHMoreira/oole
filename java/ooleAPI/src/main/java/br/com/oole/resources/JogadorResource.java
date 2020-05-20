package br.com.oole.resources;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.oole.dto.JogadorDTO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.dto.UpdateJogadorDTO;
import br.com.oole.models.Jogador;
//import br.com.oole.dto.NewJogadorDTO;
//import br.com.oole.dto.UpdateJogadorDTO;
//import br.com.oole.models.Endereco;
//import br.com.oole.models.Jogador;
//import br.com.oole.services.EnderecoService;
import br.com.oole.services.JogadorService;

@RestController
@RequestMapping(value = "/jogadores")
public class JogadorResource {
	
	@Autowired
	private JogadorService jogadorService;

	
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
	public ResponseEntity<Void> insert(@Valid @RequestBody NewJogadorDTO objDto) throws ParseException {
		Jogador obj = jogadorService.fromDTO(objDto);
		obj = jogadorService.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		jogadorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Jogador>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="jogadoresSeguidores") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Jogador> list = jogadorService.findPage(page, linesPerPage, orderBy, direction); 
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/search",method=RequestMethod.GET)
	public ResponseEntity<Page<JogadorDTO>> findPage(
			@RequestParam(value="login", defaultValue="") String login, 
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Jogador> list = jogadorService.search(login, page, linesPerPage, orderBy, direction);
		Page<JogadorDTO> listDto = list.map(obj -> Jogador.toDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@RequestBody UpdateJogadorDTO obj, @PathVariable Integer id) {
		jogadorService.update(obj, id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/follow")
	public ResponseEntity<Void> follow(@RequestParam(value="userid") Integer seguidorId, @RequestParam(value="seguidoid") Integer seguidoId) {
		jogadorService.follow(seguidorId, seguidoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/unfollow")
	public ResponseEntity<Void> unfollow(@RequestParam(value="userid") Integer seguidorId, @RequestParam(value="seguidoid") Integer seguidoId) {
		jogadorService.unfollow(seguidorId, seguidoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}/fotoperfil")
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file, @PathVariable(name ="id") Integer id) {
		URI uri = jogadorService.uploadProfilePicture(file, id);
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value="/{id}/videos")
	public ResponseEntity<Void> uploadVideo(
			@RequestParam(name="file") MultipartFile file, 
			@RequestParam(name="title") String title,
			@RequestParam(name="desc") String desc,
			@PathVariable(name ="id") Integer id) {
		URI uri = jogadorService.uploadVideos(file, id, title, desc);
		return ResponseEntity.created(uri).build();
	}
}
