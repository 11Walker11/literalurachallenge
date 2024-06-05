package com.aluracursos.literalurachallenge.principal;

import com.aluracursos.literalurachallenge.model.*;
import com.aluracursos.literalurachallenge.repository.AutoresRepository;
import com.aluracursos.literalurachallenge.repository.LibreriaRepository;
import com.aluracursos.literalurachallenge.service.ConsumoApi;
import com.aluracursos.literalurachallenge.service.ConvierteDatos;
import com.aluracursos.literalurachallenge.service.LibroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConsumoApi consumoAPI = new ConsumoApi();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner teclado = new Scanner(System.in);
    private List<DatosLibro> datosLibros = new ArrayList<>();
    private LibroService libroService;

    public Principal(LibroService libroService) {
        this.libroService = libroService;
    }

    public void muestraElMenu(){
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en determinado año
                    5 - Listar libros por idioma
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibro();
                    break;
                case 2:
                    listarLibrosRegistrados();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    listarAutoresVivosEnAno();
                    break;
                case 5:
                    listarLibrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }
//    private DatosLibro getDatosLibro() {
//        var json = consumoAPI.obtenerDatos(URL_BASE);
//        var datos = conversor.obtenerDatos(json, Datos.class);
//        System.out.println("Ingrese el nombre del libro que desea buscar");
//        var tituloLibro = teclado.nextLine();
//        json = consumoAPI.obtenerDatos(URL_BASE + tituloLibro.replace(" ","+"));
//        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
//
//        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
//                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
//                .findFirst();
//        if (libroBuscado.isPresent()) {
//            System.out.println("Libro Encontrado:");
//            //System.out.println(libroBuscado.get());
//            return libroBuscado.get();
//        } else {
//            System.out.println("Libro no encontrado");
//            return null; // O puedes lanzar una excepción si prefieres
//        }
//    }

    private DatosLibro getDatosLibro() {
        System.out.println("Ingrese el nombre del libro que desea buscar");
        var tituloLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);

        Optional<DatosLibro> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado:");
            return libroBuscado.get();
        } else {
            System.out.println("Libro no encontrado");
            return null;
        }
    }

    private void buscarLibro() {
        DatosLibro datos = getDatosLibro();
        if (datos != null) {
            Libro libro = new Libro(datos);
            for (DatosAutor datosAutor : datos.autores()) {
                Autor autor = new Autor(datosAutor);
                libroService.guardarLibroConAutor(libro, autor);
            }
            System.out.println("Libro guardado: \n" + libro);
        }
    }

    private void listarLibrosRegistrados() {
        List<Libro> libros = libroService.listarLibros();
        libros.forEach(System.out::println);
    }

    private void listarAutoresRegistrados() {
        List<Autor> autores = libroService.listarAutores();
        autores.forEach(System.out::println);
    }

    private void listarAutoresVivosEnAno() {
        System.out.println("Ingrese el año:");
        String year = teclado.nextLine();
        List<Autor> autores = libroService.buscarAutoresVivosEnAno(year);
        autores.forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.println("Ingrese el idioma: " +
                "\n Español - es " +
                "\n Ingles - en " +
                "\n Franses - fr " +
                "\n Portugues - pt ");
        String idioma = teclado.nextLine();
        List<Libro> libros = libroService.buscarLibrosPorIdioma(idioma);
        libros.forEach(System.out::println);
    }


}
