package dev.repository;

import org.springframework.data.repository.CrudRepository;

import dev.domain.NoteDeFrais;

public interface NoteDeFraisRepo extends CrudRepository<NoteDeFrais, Long> {

}
