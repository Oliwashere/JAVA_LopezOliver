/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private String nombre;
    private List<Personal> personal;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.personal = new ArrayList<>();
    }

    public void agregarPersonal(Personal personal) {
        this.personal.add(personal);
    }

    // Getters y setters
}

