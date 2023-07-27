package com.example.demo.service;

import java.util.Optional;

public interface GeneralService<E> {
    Iterable<E> findAll();
    Optional<E> findOne(Long id);
    E save(E e);
    void remove(Long id);
}
