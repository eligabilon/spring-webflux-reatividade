package com.api.webflux.document;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {

	@Id
	private String id;
	private String name;

	public Playlist() {
		this.id = UUID.randomUUID().toString();
	}

}
