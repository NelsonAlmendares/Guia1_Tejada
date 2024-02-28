package almendradezsanchezlopez;
import java.time.LocalDate;
import java.time.Period;
public class clsPersona {
        protected String dui = "0000000-0";
        protected String nom = "PENDIENTE";
        protected LocalDate fechanac = LocalDate.of(1800, 1, 1);

        public clsPersona() {}

        public String getDui() {
                return dui;
        }

        public void setDui(String dui) {
                if (validarDui(dui)) {
                        this.dui = dui;
                } else {
                        System.out.println("Formato de DUI no válido. No se ha realizado el cambio.");
                }
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                if (nom.length() >= 3) {
                        this.nom = nom;
                } else {
                        System.out.println("El nombre debe tener al menos 3 caracteres. No se ha realizado el cambio.");
                }
        }

        public LocalDate getFechanac() {
                return fechanac;
        }

        public void setFechanac(LocalDate fechanac) {
                this.fechanac = fechanac;
        }

        public int getEdad() {
                LocalDate fechaActual = LocalDate.now();
                Period periodo = Period.between(fechanac, fechaActual);
                return periodo.getYears();
        }

        public void verInfo() {}

        private boolean validarDui(String dui) {
                // Validar el formato del DUI
                // Formato válido: entre 5 y 9 dígitos seguido de un guion y un dígito
                return dui.matches("^\\d{5,9}-\\d$");
        }
}
