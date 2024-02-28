package almendradezsanchezlopez;
import java.time.LocalDate;
import java.time.Period;
import almendradezsanchezlopez.Especialidad;
public class clsDoctor {
    private static int contadorDoctores = 0;
    private final String iddoc;
    private String nombre;
    private LocalDate fechanac;
    private Especialidad especialidad;

    public clsDoctor(String nombre, Especialidad especialidad, LocalDate fechanac) {
        contadorDoctores++;
        this.iddoc = String.format("D%06d", contadorDoctores);
        this.nombre = nombre;
        this.fechanac = fechanac;
        this.especialidad = especialidad;
    }

    public String getIddoc() {
        return iddoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    public void setFechanac(LocalDate fechanac) {
        if (validarEdad(fechanac)) {
            this.fechanac = fechanac;
        } else {
            System.out.println("La fecha de nacimiento no cumple con los requisitos de edad. No se ha realizado el cambio.");
        }
    }

    public void verInfo() {
        int edad = calcularEdad();
        System.out.println("* Codigo Doctor: " + iddoc);
        System.out.println("* Nombre: " + nombre);
        System.out.println("* Edad: " + edad + " años");
        System.out.println("* Especialidad: " + especialidad);
    }

    private boolean validarEdad(LocalDate fechanac) {
        LocalDate fechaMinima = LocalDate.now().minusYears(60); // Mínimo 60 años atrás
        LocalDate fechaMaxima = LocalDate.now().minusYears(18); // Máximo 18 años atrás
        return !fechanac.isBefore(fechaMinima) && !fechanac.isAfter(fechaMaxima);
    }

    private int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - fechanac.getYear();
    }

    public enum Especialidad {
        Cardiologia,
        Ginecologia,
        Neumologia,
        Oftalmologia,
        Neurologia,
        Pediatria,
        Psicologia,
        Urologia
    }
}