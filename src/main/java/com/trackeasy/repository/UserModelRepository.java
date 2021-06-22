package com.trackeasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.UserModel;


@Repository
public interface UserModelRepository extends JpaRepository<UserModel,Long>{
  Optional<UserModel> findByUsername(String username);
  Optional<UserModel> findByEmail(String email);
  long deleteByEmail(String email);
}