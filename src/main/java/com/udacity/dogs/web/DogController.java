package com.udacity.dogs.web;

import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> dogs = this.dogService.getDogs();
        return new ResponseEntity<>(dogs, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds")
    public ResponseEntity<List<String>> getBreeds() {
        List<String> dogBreeds = this.dogService.getDogBreeds();
        return new ResponseEntity<>(dogBreeds, HttpStatus.OK);
    }

    @GetMapping("/dogs/names")
    public ResponseEntity<List<String>> getNames() {
        List<String> dogNames = this.dogService.getDogNames();
        return new ResponseEntity<>(dogNames, HttpStatus.OK);
    }

    @GetMapping("/dogs/breeds/{id}")
    public ResponseEntity<String> getBreedById(@PathVariable Long id) {
        String dogBreed = this.dogService.getDogBreedById(id);
        return new ResponseEntity<>(dogBreed, HttpStatus.OK);
    }
}
