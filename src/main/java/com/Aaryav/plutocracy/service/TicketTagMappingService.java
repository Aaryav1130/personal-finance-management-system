package com.Aaryav.plutocracy.service;

import org.springframework.stereotype.Service;

import com.Aaryav.plutocracy.repository.TicketTagMappingRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TicketTagMappingService {

	private final TicketTagMappingRepository ticketTagMappingRepository;

}
