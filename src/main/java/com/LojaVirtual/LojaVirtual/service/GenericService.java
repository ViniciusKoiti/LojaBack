package com.LojaVirtual.LojaVirtual.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import jakarta.servlet.GenericFilter;

@Service
public class GenericService<T> {
    
    @Autowired
    private JpaRepository<T, Long> repository;
    
    public Page<T> buscaTodosPaginado(GenericFilter filter, Pageable pageable) {
        return repository.findAll(pageable);
    }
}
