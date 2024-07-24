/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.Date;

public class Personal extends Persona {
    private Date fechaVinculacion;
    private double salario;

    public Personal(String titulo, String nombre, String segundoNombre, String apellidos, String direccion, Date fechaVinculacion, double salario) {
        super(titulo, nombre, segundoNombre, apellidos, direccion);
        this.fechaVinculacion = fechaVinculacion;
        this.salario = salario;
    }

    // Getters y setters
}

