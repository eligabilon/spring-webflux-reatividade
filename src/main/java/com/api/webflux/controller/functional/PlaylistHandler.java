package com.api.webflux.controller.functional;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.api.webflux.document.Playlist;
import com.api.webflux.services.PlaylistService;

import reactor.core.publisher.Mono;

//@Component //comentado para usar o spring events
public class PlaylistHandler {

	@Autowired
	PlaylistService service;

	public Mono<ServerResponse> findAll(ServerRequest req) {
		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findAll(), Playlist.class);
	}

	public Mono<ServerResponse> findById(ServerRequest req) {
		final String id = req.pathVariable("id");

		return ok().contentType(MediaType.APPLICATION_JSON).body(service.findById(id), Playlist.class);
	}

	public Mono<ServerResponse> save(ServerRequest req) {
		final Mono<Playlist> playlist = req.bodyToMono(Playlist.class);

		return ok().contentType(MediaType.APPLICATION_JSON).body(playlist.flatMap(service::save), Playlist.class);
	}

}
