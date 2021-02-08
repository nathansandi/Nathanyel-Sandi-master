package de.smava.homework.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import de.smava.homework.loan.entity.LoanEntity;


public interface LoanRepository extends JpaRepository<LoanEntity, String> {
	 List<LoanEntity> findByCustomerId(String customerId);
}
