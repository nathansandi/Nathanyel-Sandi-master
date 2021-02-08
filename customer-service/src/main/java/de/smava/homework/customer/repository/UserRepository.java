package de.smava.homework.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.smava.homework.customer.entity.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, String> {

}
