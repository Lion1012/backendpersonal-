package com.sistemas.informaticos.repositories;

import org.springframework.stereotype.Repository;

import com.sistemas.informaticos.models.Campeon;

import org.springframework.data.repository.CrudRepository;


@Repository
public interface CampeonRepository extends CrudRepository <Campeon, Long>{

}
