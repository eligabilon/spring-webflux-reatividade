package com.api.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.api.webflux.document.Playlist;

@Repository
public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{
	
}
