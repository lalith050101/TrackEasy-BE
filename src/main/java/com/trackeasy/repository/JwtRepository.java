package com.trackeasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.JwtModel;


@Repository
public interface JwtRepository extends JpaRepository<JwtModel,Long> {
	Optional<JwtModel> findByToken(String jwt);
}
