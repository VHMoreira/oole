package br.com.oole.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.licensemanager.model.AuthorizationException;

import br.com.oole.DAO.OlheiroDAO;
import br.com.oole.dto.NewOlheiroDTO;
import br.com.oole.dto.OlheiroDTO;
import br.com.oole.models.Jogador;
import br.com.oole.models.Olheiro;
import br.com.oole.security.UserSS;
import br.com.oole.services.exceptions.FileException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class OlheiroService {
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private JogadorService jogadorService;
	
	@Autowired
	private OlheiroDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@Autowired
	private S3Service s3Service;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
	
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
		seguidor.getOlheirosSeguindo().add(seguido);
		
		dao.saveAll(Arrays.asList(seguido, seguidor));
		
		return seguido;
	}
	
	public Olheiro unfollow(Integer seguidorId, Integer seguidoId) {
		Olheiro seguidor = find(seguidorId);
		Olheiro seguido = find(seguidoId);
		
		seguido.getOlheirosSeguidores().remove(seguidor);
		seguidor.getOlheirosSeguindo().remove(seguido);
		
		dao.saveAll(Arrays.asList(seguido, seguidor));
		
		return seguido;
	}
	
	public Olheiro observe(Integer userId, Integer observadoId) {
		Olheiro olheiro = find(userId);
		Jogador jogador = jogadorService.find(observadoId);
		
		jogador.getOlheiros().add(olheiro);
		olheiro.getJogadores().add(jogador);
		
		dao.save(olheiro);
		
		return olheiro;
	}
	
	public Olheiro notObserve(Integer userId, Integer observadoId) {
		Olheiro olheiro = find(userId);
		Jogador jogador = jogadorService.find(observadoId);
		
		jogador.getOlheiros().remove(olheiro);
		olheiro.getJogadores().remove(jogador);
		
		dao.save(olheiro);
		
		return olheiro;
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile, Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + id + "Olheiro" + ".jpg";
		URL url = s3Service.uploadImage(imageService.getInputStream(jpgImage, "jpg"), fileName, "image", "OLHEIRO");
		
		updateProfilePicture(url, id);
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}
	
	public Olheiro updateProfilePicture(URL url, Integer id) {
		Olheiro newObj = find(id);
		newObj.setUrlFotoPerfil(url.toString());
		return dao.save(newObj);
	}
	
	public Olheiro update(OlheiroDTO obj, Integer id) {
		Olheiro newObj = find(id);
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	public Page<Olheiro> search(String login, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAllByLogin(login, pageRequest);
	}
	
	private void updateData(Olheiro newObj, OlheiroDTO obj) {
		if(obj.getNome() != null && obj.getNome() != "") newObj.setNome(obj.getNome());
		if(obj.getLogin() != null && obj.getLogin() != "") newObj.setLogin(obj.getLogin());
		
		if(obj.getNacionalidade() != null && obj.getNacionalidade() != "") newObj.setNacionalidade(obj.getNacionalidade());
		
		if(obj.getCep() != null && obj.getCep() != "") newObj.setCep(obj.getCep());
		if(obj.getEndereco() != null && obj.getEndereco() != "") newObj.setEndereco(obj.getEndereco());
		if(obj.getBairro() != null && obj.getBairro() != "") newObj.setBairro(obj.getBairro());
		if(obj.getCidade() != null && obj.getCidade() != "") newObj.setCidade(obj.getCidade());
		if(obj.getEstado() != null && obj.getEstado() != "") newObj.setEstado(obj.getEstado());
		
		if(obj.getEmail() != null && obj.getEmail() != "") newObj.setEmail(obj.getEmail());
		if(obj.getTelefone() != null && obj.getTelefone() != "") newObj.setTelefone(obj.getTelefone());
	}

	public Olheiro fromDTO(NewOlheiroDTO objDto){
		String senha = bc.encode(objDto.getSenha());
		return new Olheiro(null,objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), 
							objDto.getSexo(), '@'+objDto.getLogin(), senha, objDto.getEmail(), 
							objDto.getTelefone(), objDto.getNacionalidade(),objDto.getCep(),
							objDto.getBairro(),objDto.getCidade(),objDto.getEstado(),
							objDto.getEndereco());
	}

}
