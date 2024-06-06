package com.aluracursos.literalurachallenge.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nombre;

    private String fechaDeNacimiento;

    private String fechaDeFallecimiento;

    @OneToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Libro> libros;

    public Autor(){}

    public Autor(DatosAutor datosAutor) {
        this.nombre = datosAutor.nombre();
        this.fechaDeNacimiento = datosAutor.fechaDeNacimiento();
        this.fechaDeFallecimiento = datosAutor.fechaDeFallecimiento();
    }


    @Override
    public String toString() {
        StringBuilder librosStr = new StringBuilder();
        if (libros != null && !libros.isEmpty()) {
            librosStr.append("Libros:\n");
            for (Libro libro : libros) {
                librosStr.append("    - ").append(libro.getTitulo()).append("\n");
            }
        } else {
            librosStr.append("Libros: No hay libros registrados\n");
        }

        return "-----------------------------\n" +
                "         Ficha del Autor\n" +
                "-----------------------------\n" +
                "Nombre                : " + nombre + "\n" +
                "Fecha de Nacimiento   : " + (fechaDeNacimiento != null ? fechaDeNacimiento : "N/A") + "\n" +
                "Fecha de Fallecimiento: " + (fechaDeFallecimiento != null ? fechaDeFallecimiento : "N/A") + "\n" +
                librosStr.toString() +
                "-----------------------------";
    }



    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l -> l.setAutor(this));
        this.libros = libros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(String fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getFechaDeFallecimiento() {
        return fechaDeFallecimiento;
    }

    public void setFechaDeFallecimiento(String fechaDeFallecimiento) {
        this.fechaDeFallecimiento = fechaDeFallecimiento;
    }
}
