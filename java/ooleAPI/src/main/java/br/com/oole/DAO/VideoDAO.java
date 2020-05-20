package br.com.oole.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.oole.models.Video;

public interface VideoDAO extends JpaRepository<Video, Integer>{
	
}
