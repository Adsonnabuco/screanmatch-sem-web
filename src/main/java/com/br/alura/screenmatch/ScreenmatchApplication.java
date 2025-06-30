package com.br.alura.screenmatch;

import com.br.alura.screenmatch.model.DadosEpisodio;
import com.br.alura.screenmatch.model.DadosSerie;
import com.br.alura.screenmatch.model.DadosTemporada;
import com.br.alura.screenmatch.principal.Principal;
import com.br.alura.screenmatch.service.ConsumoAPI;
import com.br.alura.screenmatch.service.ConverterDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
