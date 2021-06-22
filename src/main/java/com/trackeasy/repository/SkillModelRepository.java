package com.trackeasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.SkillModel;

@Repository
public interface SkillModelRepository extends JpaRepository<SkillModel,Long>{
	Optional<SkillModel> findBySkillName(String skillModel);
}
