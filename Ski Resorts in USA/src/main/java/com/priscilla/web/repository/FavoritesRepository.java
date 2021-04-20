package com.priscilla.web.repository;

import com.priscilla.web.entity.user.Favorites;
import com.priscilla.web.entity.user.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends CrudRepository {

    // Id Query
    Optional<Favorites> findById (String id);

    // Select not Inactive
    List<Favorites> findByIsInactiveFalse();

    // Select not Deleted
    List<Favorites> findByIsDeletedFalse();
}
