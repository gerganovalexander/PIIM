package com.tinqin.academy.piim.data.repositories;

import com.tinqin.academy.piim.data.models.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findUserById(Long id);

    boolean existsUserByEmail(String email);

    @Transactional
    @Modifying
    @Query(
            "UPDATE User u SET u.firstName = :#{#newUser.firstName}, u.lastName = :#{#newUser.lastName}, u.email = :#{#newUser.email} WHERE u.id = :userId")
    void updateFieldsByUser(@Param("userId") Long userId, @Param("newUser") User newUser);

    @Query("SELECT u from User u")
    List<User> getAllUsers();
}
