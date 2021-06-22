package com.trackeasy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.JobModel;

@Repository
public interface JobModelRepository extends JpaRepository<JobModel,Long> {

	@Query(" SELECT j FROM JobModel j join j.eligibleStudents e WHERE e.email = ?1 ")
	List<JobModel> findEligibleJobs(String email);
}

