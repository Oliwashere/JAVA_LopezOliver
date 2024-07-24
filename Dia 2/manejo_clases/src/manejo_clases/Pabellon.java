/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.ArrayList;
import java.util.List;

public class Pabellon {
    private String nombre;
    private int capacidad;
    private List<Paciente> pacientes;

    public Pabellon(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.pacientes = new ArrayList<>();
    }

    public boolean asignarPaciente(Paciente paciente) {
        if (pacientes.size() < capacidad) {
            pacientes.add(paciente);
            paciente.setPabellon(this);
            return true;
        }
        return false;
    }

    // Getters y setters
}

