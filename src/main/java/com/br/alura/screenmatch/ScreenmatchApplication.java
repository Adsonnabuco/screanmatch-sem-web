package com.br.alura.screenmatch;

import com.br.alura.screenmatch.model.DadosEpisodio;
import com.br.alura.screenmatch.model.DadosSerie;
import com.br.alura.screenmatch.model.DadosTemporada;
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
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.ObterDados("https://www.omdbapi.com/?t=friends&apikey=d4c38090");
		System.out.println(json);

		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);

		json = consumoApi.ObterDados("https://www.omdbapi.com/?t=friends&season=1&episode=2&apikey=d4c38090");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio);

		List<DadosTemporada> temporadas = new ArrayList<>();


		for (int i = 1; i<-dados.totalTemporadas(); i++) {

			json = consumoApi.ObterDados("https://www.omdbapi.com/?t=friends&season="+i+"&apikey=d4c38090");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			temporadas.add(dadosTemporada);
		}
		temporadas.forEach(System.out::println);


	}
}
