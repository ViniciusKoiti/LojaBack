package com.LojaVirtual.LojaVirtual.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LojaVirtual.LojaVirtual.service.GenericService;

import jakarta.servlet.GenericFilter;

public abstract class  GenericController<T> {
    
    @Autowired
    private GenericService<T> service;
    
    public ResponseEntity<Page<T>> getPaginatedData(
            GenericFilter filter, 
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<T> resultPage = service.buscaTodosPaginado(filter, pageable);
        return new ResponseEntity<>(resultPage, HttpStatus.OK);
    }
}