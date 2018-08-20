package dev.repository;

import org.springframework.data.repository.CrudRepository;

import dev.domain.NatureMission;

public interface NatureMissionRepo extends CrudRepository<NatureMission, Long> {

}
