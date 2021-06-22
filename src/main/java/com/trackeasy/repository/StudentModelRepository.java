package com.trackeasy.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.StudentModel;

@Repository
public interface StudentModelRepository extends JpaRepository<StudentModel,String>{

	Optional<StudentModel> findByEmail(String email);
	long deleteByEmail(String email);
	
	@Query(value = " SELECT s FROM StudentModel s WHERE department IN ?1 AND batch=?2 AND tenthPercentage>=?3 AND twelfthPercentage>=?4 AND degreePercentage>=?5 and standingArrears<=?6 AND historyOfArrears<=?7")
	Set<StudentModel> findEligible(@Param("depts") List<String> eligibleDepartments, String eligibleBatch, double minTenthPercentage, 
			double minTwelfthPercentage, double minDegreePercentage, int maxStandingArrears, int maxHistoryOfArrears);
}