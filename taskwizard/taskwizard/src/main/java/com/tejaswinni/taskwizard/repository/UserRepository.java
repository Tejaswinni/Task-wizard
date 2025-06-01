package com.tejaswinni.taskwizard.repository;


import com.tejaswinni.taskwizard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

/**
 * UserRepository extends JpaRepository to provide CRUD operations for the User entity.
 * JpaRepository provides a wide range of methods for interacting with the database.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Custom query to find a user by email.
     *
     * @param email The email of the user to find.
     * @return An Optional containing the User if found, otherwise empty.
     */
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    /**
     * Check if a user exists by email.
     *
     * @param email The email to check.
     * @return True if a user with the given email exists, false otherwise.
     */
    boolean existsByEmail(String email); // Spring Data JPA will automatically implement this query.
}