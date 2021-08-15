package com.api.webflux;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.api.webflux.document.Playlist;
import com.api.webflux.repository.PlaylistRepository;

import reactor.core.publisher.Flux;

//@Component
public class DummyData implements CommandLineRunner{

	private final PlaylistRepository playlistRepository;
	
	DummyData(PlaylistRepository playlistRepo) {
		this.playlistRepository = playlistRepo;
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		playlistRepository.deleteAll()
		.thenMany(
				Flux.just("Maçã Salada Mista","Pera do Sul","Molejo do Agreste","Chaqualha e Caicai","Zé da bota e Ourinho")
				.map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
				.flatMap(playlistRepository::save)).subscribe(System.out::println);
		
	}

}
