package com.Aaryav.plutocracy.service;

import org.springframework.stereotype.Service;

import com.Aaryav.plutocracy.repository.NoteTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteTagMappingService {

	private final NoteTagMappingRepository noteTagMappingRepository;

}
