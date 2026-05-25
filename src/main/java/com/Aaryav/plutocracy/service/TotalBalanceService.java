package com.Aaryav.plutocracy.service;

import org.springframework.stereotype.Service;

import com.Aaryav.plutocracy.repository.TotalBalanceRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TotalBalanceService {

	private final TotalBalanceRepository totalBalanceRepository;

}
