package br.com.oole.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.oole.DAO.VideoDAO;
import br.com.oole.models.Video;
import br.com.oole.services.exceptions.FileException;

@Service
public class VideoService {
	
	@Autowired
	private VideoDAO dao;
	
	public Video insert(Video obj) {
		return dao.save(obj);
	}
	
	public void deleteFromlLocal(String name) {
		File myObj = new File(name);
		myObj.delete();
	}
	
	public File getInputStream(MultipartFile file, String extension) {
		try {
			File convFile = new File(file.getOriginalFilename());
	        FileOutputStream fos = new FileOutputStream(convFile);
	        fos.write(file.getBytes());
	        fos.close();
	        return convFile;
		} catch (IOException e) {
			throw new FileException("Erro ao ler arquivo");
		}
		
	}
	
	
	
//	public InputStream getInputStream(BufferedImage img, String extension) {
//		try {
//			ByteArrayOutputStream os = new ByteArrayOutputStream();
//			ImageIO.write(img, extension, os);
//			return new ByteArrayInputStream(os.toByteArray());
//		} catch (IOException e) {
//			throw new FileException("Erro ao ler arquivo");
//		}
//	}
}
