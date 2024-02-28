package principal;
import almendradezsanchezlopez.clsDoctor;
import almendradezsanchezlopez.clsPaciente;
import java.time.LocalDate;

//LT222760 SM232984 AR230429
public class Main {
    public static void main(String[] args) {
        // Paso 1: Crear 3 instancias de la clase clsDoctor
        clsDoctor doctor1 = new clsDoctor("Juan Perez", clsDoctor.Especialidad.Cardiologia, LocalDate.of(2014, 1, 1));
        clsDoctor doctor2 = new clsDoctor("AB", clsDoctor.Especialidad.Neumologia, LocalDate.of(1998, 1, 1));
        clsDoctor doctor3 = new clsDoctor("Maria Garcia", clsDoctor.Especialidad.Oftalmologia, LocalDate.of(1990, 1, 1));

        // Paso 2: Invocar el método VerInfo de los 3 objetos doctores
        System.out.println("Información de los doctores:");
        doctor1.verInfo();
        doctor2.verInfo();
        doctor3.verInfo();

        // Paso 3: Crear 2 instancias de la clase clsPaciente
        clsPaciente paciente1 = new clsPaciente("Alexia Juarez", LocalDate.of(2005, 1, 1), null);
        clsPaciente paciente2 = new clsPaciente("Carlos Lopez", LocalDate.of(1985, 1, 1), "Gripe");

        // Paso 4: Asignar datos válidos al resto de objetos pacientes
        paciente1.setIdDoctorAsignado(doctor1.getIddoc());
        paciente2.setIdDoctorAsignado(doctor3.getIddoc());

        // Paso 5: Invocar el método VerInfo de cada paciente
        System.out.println("\nInformación de los pacientes:");
        paciente1.verInfo();
        paciente2.verInfo();
    }
}
