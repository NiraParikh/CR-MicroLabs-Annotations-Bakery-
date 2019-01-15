package com.zipcodewilmington.bakery.Controllers;

import com.zipcodewilmington.bakery.Models.Muffin;
import com.zipcodewilmington.bakery.Repositories.MuffinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MuffinController {

    private MuffinRepository muffinRepository;

    @Autowired
    public MuffinController(MuffinRepository muffinRepository) {
        this.muffinRepository = muffinRepository;
    }


    @GetMapping("/Muffin/")
    public ResponseEntity<Iterable<Muffin>> index() {
        return new ResponseEntity<>(this.muffinRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/Muffin/{id}")
    public ResponseEntity<Muffin> show(@PathVariable Long id) {
        return new ResponseEntity<>(this.muffinRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/Muffin/")
    public ResponseEntity<Muffin> create(@RequestBody Muffin muffin) {
        return new ResponseEntity<>(this.muffinRepository.save(muffin), HttpStatus.CREATED);
    }

    @PutMapping("/Muffin/{id}")
    public ResponseEntity<Muffin> update(@PathVariable Long id, @RequestBody Muffin muffin) {
        Muffin foundMuffin = muffinRepository.findById(id).get();
        foundMuffin.setFlavor(muffin.getFlavor());

        return new ResponseEntity<>(this.muffinRepository.save(foundMuffin), HttpStatus.OK);
    }

    @DeleteMapping("/Muffin/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id){
        this.muffinRepository.delete(this.muffinRepository.findById(id).get());
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
