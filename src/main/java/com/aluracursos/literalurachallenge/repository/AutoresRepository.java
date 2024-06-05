package com.aluracursos.literalurachallenge.repository;

import com.aluracursos.literalurachallenge.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutoresRepository extends JpaRepository<Autor,Long> {
    Autor findByNombre(String nombre);

    List<Autor> findAll();

    @Query("SELECT a FROM Autor a WHERE a.fechaDeNacimiento <= :year AND (a.fechaDeFallecimiento IS NULL OR a.fechaDeFallecimiento > :year)")
    List<Autor> findAutoresVivosEnAno(String year);
}
