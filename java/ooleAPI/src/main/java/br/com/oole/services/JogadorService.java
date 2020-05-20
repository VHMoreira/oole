package br.com.oole.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Date;
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

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.dto.NewJogadorDTO;
import br.com.oole.dto.UpdateJogadorDTO;
import br.com.oole.models.Jogador;
import br.com.oole.models.Video;
import br.com.oole.security.UserSS;
import br.com.oole.services.exceptions.FileException;
import br.com.oole.services.exceptions.ObjectNotFoundException;

@Service
public class JogadorService {
	
	@Autowired
	private JogadorDAO dao;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private VideoService videoService;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	@Value("${img.profile.size}")
	private Integer size;
	
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
		seguidor.getJogadoresSeguindo().add(seguido);
		
		dao.saveAll(Arrays.asList(seguido, seguidor));
		
		return seguido;
	}
	
	public Jogador unfollow(Integer seguidorId, Integer seguidoId) {
		Jogador seguidor = find(seguidorId);
		Jogador seguido = find(seguidoId);
		
		seguido.getJogadoresSeguidores().remove(seguidor);
		seguidor.getJogadoresSeguindo().remove(seguido);
		
		dao.saveAll(Arrays.asList(seguido, seguidor));
		
		return seguido;
	}
	
	public URI uploadVideos(MultipartFile file, Integer id, String title, String desc){
		Jogador newObj = find(id);
		Date data = new Date();
		String fileName = title + ".mp4";
		
		URL url = s3Service.uploadVideo(videoService.getInputStream(file, "mp4"), fileName, id);
		Video video = new Video(null,title,desc,url.toString(), data, 0 , 0, newObj);
		
		newObj.getVideos().add(video);
		
		videoService.insert(video);
		videoService.deleteFromlLocal(file.getOriginalFilename());
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}
	
	public URI uploadProfilePicture(MultipartFile multipartFile, Integer id) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage = imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + id + "Jogador" + ".jpg";
		URL url = s3Service.uploadImage(imageService.getInputStream(jpgImage, "jpg"), fileName, "image", "JOGADOR");
		
		updateProfilePicture(url, id);
		try {
			return url.toURI();
		} catch (URISyntaxException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}
	
	public Jogador updateProfilePicture(URL url, Integer id) {
		Jogador newObj = find(id);
		newObj.setUrlFotoPerfil(url.toString());
		return dao.save(newObj);
	}

	public Jogador update(UpdateJogadorDTO obj, Integer id) {
		Jogador newObj = find(id);
		updateData(newObj, obj);
		return dao.save(newObj);
	}
	
	public Page<Jogador> search(String login, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return dao.findAllByLogin(login, pageRequest);
	}
	
	private void updateData(Jogador newObj, UpdateJogadorDTO obj) {
		if(obj.getNome() != null && obj.getNome() != "") newObj.setNome(obj.getNome());
		if(obj.getLogin() != null && obj.getLogin() != "") newObj.setLogin(obj.getLogin());
		
		if(obj.getPosicao() != null && obj.getPosicao() != "") newObj.setPosicao(obj.getPosicao());
		if(obj.getProblemaSaude() != null && obj.getProblemaSaude() != "") newObj.setProblemaSaude(obj.getProblemaSaude());
		if(obj.getNacionalidade() != null && obj.getNacionalidade() != "") newObj.setNacionalidade(obj.getNacionalidade());
		
		if(obj.getCep() != null && obj.getCep() != "") newObj.setCep(obj.getCep());
		if(obj.getEndereco() != null && obj.getEndereco() != "") newObj.setEndereco(obj.getEndereco());
		if(obj.getBairro() != null && obj.getBairro() != "") newObj.setBairro(obj.getBairro());
		if(obj.getCidade() != null && obj.getCidade() != "") newObj.setCidade(obj.getCidade());
		if(obj.getEstado() != null && obj.getEstado() != "") newObj.setEstado(obj.getEstado());
		
		if(obj.getEmail() != null && obj.getEmail() != "") newObj.setEmail(obj.getEmail());
		if(obj.getTelefone() != null && obj.getTelefone() != "") newObj.setTelefone(obj.getTelefone());
	}

	public Jogador fromDTO(NewJogadorDTO objDto){
		String senha = bc.encode(objDto.getSenha());
		return new Jogador(null, objDto.getNome(), objDto.getDataNascimento(), objDto.getCpf(), objDto.getSexo(), objDto.getPosicao(), objDto.getProblemaSaude(), '@'+objDto.getLogin(), senha, objDto.getEmail(), objDto.getTelefone(), objDto.getNacionalidade(),objDto.getCep(),objDto.getBairro(),objDto.getCidade(),objDto.getEstado(),objDto.getEndereco());
	}

}
