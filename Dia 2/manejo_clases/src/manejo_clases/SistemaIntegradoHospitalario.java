/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manejo_clases;

import java.util.Date;

public class SistemaIntegradoHospitalario {
    public static void main(String[] args) {
        // Ejemplo de uso
        Hospital hospital = new Hospital("Hospital General");
        Departamento departamento = new Departamento("Cardiología");
        hospital.agregarDepartamento(departamento);

        Doctor doctorLider = new Doctor("Dr.", "Juan", "Carlos", "Pérez", "Calle Falsa 123", new Date(), 5000.0, true);
        Doctor doctorJunior = new Doctor("Dr.", "Ana", "María", "Gómez", "Avenida Siempre Viva 456", new Date(), 3000.0, false);

        doctorLider.agregarMiembroEquipo(doctorJunior);
        departamento.agregarPersonal(doctorLider);
        departamento.agregarPersonal(doctorJunior);

        hospital.agregarPersona(doctorLider);
        hospital.agregarPersona(doctorJunior);

        System.out.println("Nombre completo del doctor líder: " + doctorLider.getNombreCompleto());
        System.out.println("El equipo del doctor líder incluye a: " + doctorJunior.getNombreCompleto());
    }
}

