package com.udacity.dogs.web;

import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.service.DogService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiResponses(value = {
        @ApiResponse(code=400, message = "This is a bad request, please follow the API documentation for the proper request format."),
        @ApiResponse(code=401, message = "Due to security constraints, your access request cannot be authorized. "),
        @ApiResponse(code=500, message = "The server is down. Please make sure that the Dog microservice is running.")
})
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
