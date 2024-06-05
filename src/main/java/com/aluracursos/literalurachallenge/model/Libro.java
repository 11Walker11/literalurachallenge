package com.aluracursos.literalurachallenge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    private String idiomas;

    private Double numeroDeDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    Autor autor;

    public Libro(){}

    public Libro(DatosLibro datosLibro) {
        this.titulo = datosLibro.titulo();
        this.idiomas = String.join(",", datosLibro.idiomas());
        this.numeroDeDescargas = datosLibro.numeroDeDescargas();
    }


    @Override
    public String toString() {
        return "--------------------------\n" +
                "        Ficha del Libro\n" +
                "--------------------------\n" +
                "Título               : " + titulo + "\n" +
                "Autor                : " + (autor != null ? autor.getNombre() : "Desconocido") + "\n" +
                "Idioma              : " + idiomas + "\n" +
                "Número de Descargas  : " + numeroDeDescargas + "\n" +
                "--------------------------";
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public Double getNumeroDeDescargas() {
        return numeroDeDescargas;
    }

    public void setNumeroDeDescargas(Double numeroDeDescargas) {
        this.numeroDeDescargas = numeroDeDescargas;
    }
}
