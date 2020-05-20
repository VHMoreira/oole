package br.com.oole.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.oole.DAO.JogadorDAO;
import br.com.oole.models.Jogador;
import br.com.oole.models.enums.Perfil;
import br.com.oole.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private JogadorDAO dao;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Jogador j = dao.findByEmail(email);
		if (j == null) {
			throw new UsernameNotFoundException(email);
		}
		
		Set<Perfil> perfis = new HashSet<Perfil>();
		perfis.add(j.getPerfil());
		
		return new UserSS(j.getId(), j.getEmail(), j.getSenha(), perfis);
	}
}
