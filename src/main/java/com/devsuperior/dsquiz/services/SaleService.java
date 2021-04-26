package com.devsuperior.dsquiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsquiz.dto.SaleDTO;
import com.devsuperior.dsquiz.dto.SaleSumDTO;
import com.devsuperior.dsquiz.repositories.SaleRepository;
import com.devsuperior.dsquiz.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public List<SaleDTO> findAll() {
		return repository.searchAll().stream().map(x -> new SaleDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		sellerRepository.findAll();
		return repository.amountGroupedBySeller();
	}
}
