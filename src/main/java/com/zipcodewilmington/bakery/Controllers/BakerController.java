package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Baker;
import com.zipcodewilmington.bakery.Repositories.BakerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;

@RestController
public class BakerController {


    private BakerRepository bakerRepository;

    @Autowired
    public BakerController(BakerRepository bakerRepository) {
        this.bakerRepository = bakerRepository;
    }


    @GetMapping("/Baker/")
    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(this.bakerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Baker/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.bakerRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/Baker/")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(this.bakerRepository.save(baker), HttpStatus.CREATED);
    }

    @PutMapping("/Baker/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, @RequestBody Baker baker) {
        Baker foundBaker = bakerRepository.findById(id).get();

        foundBaker.setName(baker.getName());
        foundBaker.setSpecialty(baker.getSpecialty());

        return new ResponseEntity<>(this.bakerRepository.save(foundBaker), HttpStatus.OK);
    }

    @DeleteMapping("/Baker/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        this.bakerRepository.delete(this.bakerRepository.findById(id).get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
