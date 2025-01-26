package com.example.logistics.repositories.interfaces;

import com.example.logistics.models.users.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Find a customer by the associated user's ID.
     *
     * @param userId the ID of the associated user
     * @return an optional Customer object
     */
    Optional<Customer> findByUserId(Long userId);

    /**
     * Find a customer by the associated user's username.
     *
     * @param username the username of the associated user
     * @return an optional Customer object
     */
    Optional<Customer> findByUserUsername(String username);
}
