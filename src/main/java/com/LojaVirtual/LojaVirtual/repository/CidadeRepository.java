package com.LojaVirtual.LojaVirtual.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.LojaVirtual.LojaVirtual.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    Page<Cidade> buscaPaginada(Pageable pageable);
}
