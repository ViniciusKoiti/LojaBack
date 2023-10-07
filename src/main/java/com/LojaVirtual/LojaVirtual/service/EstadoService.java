package com.LojaVirtual.LojaVirtual.service;


import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.LojaVirtual.LojaVirtual.entity.Estado;
import com.LojaVirtual.LojaVirtual.repository.EstadoRepository;

import jakarta.servlet.GenericFilter;
@Service
public class EstadoService extends GenericService<Estado> {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    } 

    public Estado buscarPorId(Long id) {
        return estadoRepository.findById(id).get();
    }

    public Estado inserir (Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar (Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id) {
        Estado estado = estadoRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estado não encontrado."));
        estadoRepository.delete(estado);
    }

    public Page<Estado> buscaTodosPaginado(Pageable pageable){
        

        return estadoRepository.findAll(pageable);
    }
}