package dev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.domain.NatureMission;

@Repository
public interface NatureMissionRepo extends CrudRepository<NatureMission, Long> {

}
