package de.smava.homework.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.smava.homework.customer.entity.CustomerEntity;


public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {

}
