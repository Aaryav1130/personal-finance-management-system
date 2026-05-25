package com.aaryav.plutocracy.service;

import org.springframework.stereotype.Service;

import com.aaryav.plutocracy.repository.TicketTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketTagMappingService {

	private final TicketTagMappingRepository ticketTagMappingRepository;

}
