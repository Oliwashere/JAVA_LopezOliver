/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor extends Operaciones {
    private boolean esLider;
    private List<Doctor> equipo;

    public Doctor(String titulo, String nombre, String segundoNombre, String apellidos, String direccion, Date fechaVinculacion, double salario, boolean esLider) {
        super(titulo, nombre, segundoNombre, apellidos, direccion, fechaVinculacion, salario, true);
        this.esLider = esLider;
        this.equipo = new ArrayList<>();
    }

    public void agregarMiembroEquipo(Doctor doctor) {
        equipo.add(doctor);
    }

    // Getters y setters
}

