package com.devsuperior.dsquiz.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsquiz.dto.SaleDTO;
import com.devsuperior.dsquiz.dto.SaleSumDTO;
import com.devsuperior.dsquiz.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<List<SaleDTO>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
		return ResponseEntity.ok().body(service.amountGroupedBySeller());
	}
}
