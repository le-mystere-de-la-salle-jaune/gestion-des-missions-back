package dev.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import dev.domain.Collaborateur;

@Repository
public interface CollaborateurRepo extends BaseRepository<Collaborateur> {

	Optional<Collaborateur> findByEmail(String email);
}
