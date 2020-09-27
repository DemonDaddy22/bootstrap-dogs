package com.udacity.dogs.service;

import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    public List<Dog> getDogs() {
        return (List<Dog>) this.dogRepository.findAll();
    }

    public List<String> getDogBreeds() {
        return this.dogRepository.findDogBreeds();
    }

    public List<String> getDogNames() {
        return this.dogRepository.findDogNames();
    }

    public String getDogBreedById(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(this.dogRepository.findBreedById(id));
        return optionalBreed.orElseThrow(DogNotFoundException::new);
    }
}
