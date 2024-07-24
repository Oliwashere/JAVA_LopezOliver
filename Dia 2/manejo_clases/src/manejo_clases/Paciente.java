/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.Calendar;
import java.util.Date;

public class Paciente extends Persona {
    private Date fechaNacimiento;
    private Date fechaIngreso;
    private Pabellon pabellon;

    public Paciente(String titulo, String nombre, String segundoNombre, String apellidos, String direccion, Date fechaNacimiento, Date fechaIngreso) {
        super(titulo, nombre, segundoNombre, apellidos, direccion);
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public int getEdad() {
        Calendar birth = Calendar.getInstance();
        birth.setTime(fechaNacimiento);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    // Getters y setters
}

