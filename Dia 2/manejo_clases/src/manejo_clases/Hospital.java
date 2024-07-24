/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private String nombre;
    private List<Departamento> departamentos;
    private List<Persona> personas;

    public Hospital(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        departamentos.add(departamento);
    }

    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    // Getters y setters
}

