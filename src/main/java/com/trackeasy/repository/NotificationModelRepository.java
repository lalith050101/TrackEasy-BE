package com.trackeasy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trackeasy.model.NotificationModel;

@Repository
public interface NotificationModelRepository extends JpaRepository<NotificationModel,Long>{

}
