package com.trackeasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.JobRoleModel;

@Repository
public interface JobRoleModelRepository extends JpaRepository<JobRoleModel,Long>{

	Optional<JobRoleModel> findByJobRoleName(String jobRoleName);
}
