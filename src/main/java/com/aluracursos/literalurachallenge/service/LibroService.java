package com.aluracursos.literalurachallenge.service;

import com.aluracursos.literalurachallenge.model.Autor;
import com.aluracursos.literalurachallenge.model.Libro;
import com.aluracursos.literalurachallenge.repository.AutoresRepository;
import com.aluracursos.literalurachallenge.repository.LibreriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibreriaRepository libroRepository;

    @Autowired
    private AutoresRepository autorRepository;

    @Transactional
    public Libro guardarLibroConAutor(Libro libro, Autor autor) {
        Autor autorExistente = autorRepository.findByNombre(autor.getNombre());
        if (autorExistente == null) {
            autorExistente = autorRepository.save(autor);
        }
        libro.setAutor(autorExistente);
        return libroRepository.save(libro);
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Libro> buscarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> buscarAutoresVivosEnAno(String year) {
        return autorRepository.findAutoresVivosEnAno(year);
    }
}
