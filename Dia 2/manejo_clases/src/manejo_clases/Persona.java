/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

public class Persona {
    private String titulo;
    private String nombre;
    private String segundoNombre;
    private String apellidos;
    private String direccion;

    public Persona(String titulo, String nombre, String segundoNombre, String apellidos, String direccion) {
        this.titulo = titulo;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return titulo + " " + nombre + " " + segundoNombre + " " + apellidos;
    }

    // Getters y setters
}

