package com.api.webflux.services.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.webflux.document.Playlist;
import com.api.webflux.repository.PlaylistRepository;
import com.api.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	PlaylistRepository playlistRepo;

	@Override
	public Flux<Playlist> findAll() {
		return playlistRepo.findAll();
	}

	@Override
	public Mono<Playlist> findById(String id) {
		return playlistRepo.findById(id);
	}

	@Override
	public Mono<Playlist> save(Playlist playlist) {
		return playlistRepo.save(playlist);
	}

}
