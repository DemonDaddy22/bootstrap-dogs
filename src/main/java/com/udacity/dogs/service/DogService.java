package com.udacity.dogs.service;

import com.udacity.dogs.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> getDogs();
    List<String> getDogBreeds();
    List<String> getDogNames();
    String getDogBreedById(Long id);
}
