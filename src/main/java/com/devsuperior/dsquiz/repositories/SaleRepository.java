package com.devsuperior.dsquiz.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsquiz.dto.SaleSumDTO;
import com.devsuperior.dsquiz.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT obj FROM Sale obj JOIN FETCH obj.seller")
	List<Sale> searchAll();
	
	@Query("SELECT new com.devsuperior.dsquiz.dto.SaleSumDTO(obj.seller, SUM(obj.amount) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller ")
	List<SaleSumDTO> amountGroupedBySeller();
}
