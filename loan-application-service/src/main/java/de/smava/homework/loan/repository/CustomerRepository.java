package de.smava.homework.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.smava.homework.loan.entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
