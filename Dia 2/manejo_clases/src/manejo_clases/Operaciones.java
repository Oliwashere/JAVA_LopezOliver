/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.Date;

public class Operaciones extends Personal {
    private boolean esDoctor;

    public Operaciones(String titulo, String nombre, String segundoNombre, String apellidos, String direccion, Date fechaVinculacion, double salario, boolean esDoctor) {
        super(titulo, nombre, segundoNombre, apellidos, direccion, fechaVinculacion, salario);
        this.esDoctor = esDoctor;
    }

    // Getters y setters
}

