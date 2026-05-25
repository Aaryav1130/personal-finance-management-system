package com.aaryav.plutocracy.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aaryav.plutocracy.entity.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, UUID> {

}
