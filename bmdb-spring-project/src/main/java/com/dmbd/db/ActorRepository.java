package com.dmbd.db;

import org.springframework.data.repository.CrudRepository;

import com.dmbd.business.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {

}
