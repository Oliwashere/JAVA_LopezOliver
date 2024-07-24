/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.Date;

public class Tecnico extends Personal {
    private boolean esTecnologia;

    public Tecnico(String titulo, String nombre, String segundoNombre, String apellidos, String direccion, Date fechaVinculacion, double salario, boolean esTecnologia) {
        super(titulo, nombre, segundoNombre, apellidos, direccion, fechaVinculacion, salario);
        this.esTecnologia = esTecnologia;
    }

    // Getters y setters
}

