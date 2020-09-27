package com.udacity.dogs.repository;

import com.udacity.dogs.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {

    String FIND_DOG_BREEDS = "SELECT id, breed from Dog";
    String FIND_DOG_NAMES = "SELECT id, name from Dog";
    String FIND_BREEDS_BY_ID = "SELECT id, breed from Dog WHERE id = :id";

    @Query(FIND_DOG_BREEDS)
    List<String> findDogBreeds();

    @Query(FIND_DOG_NAMES)
    List<String> findDogNames();

    @Query(FIND_BREEDS_BY_ID)
    String findBreedById(Long id);
}
