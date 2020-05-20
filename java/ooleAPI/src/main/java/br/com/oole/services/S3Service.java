package br.com.oole.services;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

import br.com.oole.services.exceptions.FileException;

@Service
public class S3Service {

	private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Autowired
	private AmazonS3 s3client;

	@Value("${s3.bucket}")
	private String bucketName;

	public URL uploadImage(MultipartFile multipartFile, String tipoPerfil) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadImage(is, fileName, contentType, tipoPerfil);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}
	}

	public URL uploadImage(InputStream is, String fileName, String contentType, String tipoPerfil) {
		ObjectMetadata meta = new ObjectMetadata();
		meta.setContentType(contentType);
		LOG.info("Iniciando upload");
		s3client.putObject(bucketName+"/fotos/"+tipoPerfil, fileName, is, meta);
		LOG.info("Upload finalizado");
		return s3client.getUrl(bucketName+"/fotos/"+tipoPerfil, fileName);
	}

	public URL uploadVideo(File inputStream, String fileName, int id) {
		LOG.info("Iniciando upload");
		s3client.putObject(bucketName+"/videos/"+id, fileName, inputStream);
		LOG.info("Upload finalizado");
		return s3client.getUrl(bucketName+"/videos/"+id, fileName);
	}
}
