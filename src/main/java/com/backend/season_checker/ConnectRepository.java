package com.backend.season_checker;

import org.springframework.data.repository.CrudRepository;

import com.backend.season_checker.Connectsi;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ConnectRepository extends CrudRepository<Connectsi, Integer> {

}