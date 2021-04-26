package com.devsuperior.dsquiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsquiz.dto.SaleDTO;
import com.devsuperior.dsquiz.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	public List<SaleDTO> findAll() {
		return repository.searchAll().stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
	}
}
