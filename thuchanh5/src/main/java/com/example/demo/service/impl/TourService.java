package com.example.demo.service.impl;

import com.example.demo.model.Tour;
import com.example.demo.repository.ITourRepository;
import com.example.demo.service.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TourService implements ITourService {
    @Autowired
    private ITourRepository iTourRepository;


    @Override
    public Iterable<Tour> findAll() {
        return iTourRepository.findAll();
    }

    @Override
    public Optional<Tour> findOne(Long id) {
        return iTourRepository.findById(id);
    }

    @Override
    public Tour save(Tour tour) {
        return iTourRepository.save(tour);
    }

    @Override
    public void remove(Long id) {
        iTourRepository.deleteById(id);
    }
}
