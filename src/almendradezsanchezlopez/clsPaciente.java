package almendradezsanchezlopez;

import java.time.LocalDate;

public class clsPaciente {
    private static int contadorPacientes = 0;
    private final String idPaciente;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String diagnostico;
    private String idDoctorAsignado;

    public clsPaciente(String nombre, LocalDate fechaNacimiento, String diagnostico) {
        contadorPacientes++;
        this.idPaciente = String.format("P%09d", contadorPacientes);
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.diagnostico = diagnostico;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        if (validarEdad(fechaNacimiento)) {
            this.fechaNacimiento = fechaNacimiento;
        } else {
            System.out.println("La fecha de nacimiento no cumple con los requisitos de edad. No se ha realizado el cambio.");
        }
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getIdDoctorAsignado() {
        return idDoctorAsignado;
    }

    public void setIdDoctorAsignado(String idDoctorAsignado) {
        this.idDoctorAsignado = idDoctorAsignado;
    }

    public void verInfo() {
        int edad = calcularEdad();
        System.out.println("* Codigo Paciente: " + idPaciente);
        System.out.println("> Nombre: " + nombre);
        System.out.println("> Edad: " + edad + " años");
        System.out.println("> Diagnostico: " + diagnostico);
        System.out.println("> Doctor asignado: [" + idDoctorAsignado + "]");
    }

    private boolean validarEdad(LocalDate fechaNacimiento) {
        LocalDate fechaMinima = LocalDate.now().minusYears(110); // Mínimo 110 años atrás
        LocalDate fechaMaxima = LocalDate.now().minusYears(2); // Máximo 2 años atrás
        return !fechaNacimiento.isBefore(fechaMinima) && !fechaNacimiento.isAfter(fechaMaxima);
    }

    private int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - fechaNacimiento.getYear();
    }
}