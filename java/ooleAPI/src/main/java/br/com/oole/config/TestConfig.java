package br.com.oole.config;

import java.text.ParseException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	public boolean instantiateDatabase() throws ParseException {
	
		return true;
	}
}
