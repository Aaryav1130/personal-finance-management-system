package com.aaryav.plutocracy.service;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aaryav.plutocracy.dto.request.GoalCreationRequestDto;
import com.aaryav.plutocracy.dto.request.GoalUpdationRequestDto;
import com.aaryav.plutocracy.dto.response.GoalDto;
import com.aaryav.plutocracy.entity.Goal;
import com.aaryav.plutocracy.repository.GoalRepository;
import com.aaryav.plutocracy.repository.UserRepository;
import com.aaryav.plutocracy.security.utility.JwtUtils;
import com.aaryav.plutocracy.utils.ResponseUtils;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class GoalService {

	private final GoalRepository goalRepository;

	private final UserRepository userRepository;

	private final JwtUtils jwtUtils;

	private final ResponseUtils responseUtils;

	public ResponseEntity<?> create(final GoalCreationRequestDto goalCreationRequest, final String token) {
		final var goal = new Goal();
		goal.setActive(true);
		goal.setDescription(goalCreationRequest.getDescription());
		goal.setTitle(goalCreationRequest.getTitle());
		goal.setUserId(jwtUtils.extractUserId(token.replace("Bearer ", "")));
		final var savedGoal = goalRepository.save(goal);
		return responseUtils.goalSuccessResponse(savedGoal.getId());
	}

	public ResponseEntity<?> update(final GoalUpdationRequestDto goalUpdationRequest, final String token) {
		final var goal = goalRepository.findById(goalUpdationRequest.getId()).get();
		goal.setActive(goalUpdationRequest.getIsActive());
		goal.setDescription(goalUpdationRequest.getDescription());
		final var savedGoal = goalRepository.save(goal);
		return responseUtils.goalSuccessResponse(savedGoal.getId());
	}

	public ResponseEntity<?> retreive(final String token) {
		final var user = userRepository.findById(jwtUtils.extractUserId(token.replace("Bearer ", ""))).get();
		return ResponseEntity.ok(user.getGoals().parallelStream()
				.map(goal -> GoalDto.builder().createdAt(goal.getCreatedAt()).description(goal.getDescription())
						.id(goal.getId()).isActive(goal.isActive()).title(goal.getTitle())
						.updatedAt(goal.getUpdatedAt()).build())
				.collect(Collectors.toList()));
	}

}
