package br.com.oole;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OoleApiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(OoleApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat jdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
	}

}

