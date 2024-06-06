package com.aluracursos.literalurachallenge.repository;

import com.aluracursos.literalurachallenge.model.Autor;
import com.aluracursos.literalurachallenge.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibreriaRepository extends JpaRepository<Libro, Long> {

    List<Libro> findAll();

    @Query("SELECT l FROM Libro l WHERE l.idiomas LIKE %:idioma%")
    List<Libro> findByIdiomasContaining(String idioma);

    long countByIdiomasContaining(String idioma);

    @Query("SELECT l FROM Libro l ORDER BY l.numeroDeDescargas DESC")
    List<Libro> findTop10ByOrderByNumeroDeDescargasDesc();

}
