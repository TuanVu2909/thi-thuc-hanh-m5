package com.example.demo.controller;

import com.example.demo.model.Tour;
import com.example.demo.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/tours")
public class TourController {
    @Autowired
    private
    ITourService iTourService;

    @GetMapping
    public ResponseEntity<Iterable<Tour>> findAll(){
        List<Tour> studentList = (List<Tour>) iTourService.findAll();
        if (studentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(studentList,HttpStatus.ACCEPTED);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Tour>> findOne(@PathVariable Long id){
        Optional<Tour> studentOptional = iTourService.findOne(id);
        if(!studentOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(studentOptional,HttpStatus.OK);
        }
    }
    @PostMapping
    public ResponseEntity<Tour> create(@RequestBody Tour tour){
        return new ResponseEntity<>(iTourService.save(tour),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<Tour> update(@RequestBody Tour tour, @PathVariable Long id){
        Optional<Tour> tourOptional = iTourService.findOne(id);
        if (!tourOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            tour.setId(id);
            return new ResponseEntity<>(iTourService.save(tour),HttpStatus.OK);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Tour> delete(@PathVariable Long id){
        Optional<Tour> tourOptional = iTourService.findOne(id);
        if (tourOptional.isPresent()){
            iTourService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
