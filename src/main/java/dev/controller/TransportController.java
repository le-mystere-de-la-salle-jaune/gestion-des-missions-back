package dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.domain.Transport;

@RestController
@RequestMapping("/api/transports")
public class TransportController {

	@GetMapping
	public ResponseEntity<Transport[]> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(Transport.values());
	}
}
