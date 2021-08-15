package com.api.webflux.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.webflux.document.Playlist;
import com.api.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@RestController
public class PlaylistController {

	@Autowired
	PlaylistService service;

	@GetMapping(value = "/playlist")
	public Flux<Playlist> getAllPlaylist() {
		return service.findAll();
	}

	@GetMapping(value = "/playlist/{id}")
	public Mono<Playlist> getOnePlaylist(@PathVariable String id) {
		return service.findById(id);
	}

	@PostMapping(value = "/playlist")
	public Mono<Playlist> save(@RequestBody Playlist playlist) {
		return service.save(playlist);
	}

	@GetMapping(value = "/playlist/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents(){
		
		Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));
		Flux<Playlist> events = service.findAll();
		
		System.out.println("was one step here");
		
		return Flux.zip(interval, events);
	}
	
}
