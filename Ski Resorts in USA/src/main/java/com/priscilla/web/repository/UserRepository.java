package com.priscilla.web.repository;


import com.priscilla.web.entity.skiresort.SkiResort;
import com.priscilla.web.entity.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    // Id Query
    Optional<User> findById (String id);

    // Email Query
    Optional<User> findByEmail (String email);

    // Select All
    List<User> findAllOrderedById();

    // Select not Inactive
    List<User> findByIsInactiveFalse();

    // Select not Deleted
    List<User> findByIsDeletedFalse();

    // Name Query
    List<User> findByNameContaining (String name, Sort sort);

    // Email Query
    List<User> findByEmailContaining (String email, Sort sort);

    // Role Queries
    List<User> findByRole(String role, Sort sort);

}
