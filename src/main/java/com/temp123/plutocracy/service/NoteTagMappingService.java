package com.aaryav.plutocracy.service;

import org.springframework.stereotype.Service;

import com.aaryav.plutocracy.repository.NoteTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteTagMappingService {

	private final NoteTagMappingRepository noteTagMappingRepository;

}
