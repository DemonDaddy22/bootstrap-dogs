package com.udacity.dogs.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.udacity.dogs.entity.Dog;
import com.udacity.dogs.exception.BreedNotFoundException;
import com.udacity.dogs.repository.DogRepository;
import com.udacity.dogs.service.DogNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for (Dog d:allDogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }
        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = this.dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            this.dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found", id);
        }
    }
}
