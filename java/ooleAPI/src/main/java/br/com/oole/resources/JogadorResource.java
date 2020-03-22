package br.com.oole.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oole.models.Jogador;
import br.com.oole.services.JogadorService;

@RestController(value = "/jogador")
public class JogadorResource {
	
	@Autowired
	private JogadorService perfilService;
	
	@GetMapping
	public ResponseEntity<List<Jogador>> listar() {
		return ResponseEntity.ok(perfilService.findAll());
	}
}
