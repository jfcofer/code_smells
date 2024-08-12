public class refactored_parallel_inheritance {
        /*
    * Solución:
    * 1. Define una interfaz `Enrollable` que declare el método para inscribirse en cursos.
    * 2. Crea clases concretas `Profesor` y `Alumno` que implementen la interfaz `Enrollable`.
    * 3. Usa una clase `Persona` que contenga una instancia de `Enrollable` para manejar la inscripción.
    */

    // Interfaz para funcionalidad de inscripción
    interface Enrollable {
        void inscribirEnCurso(String curso);
    }

    // Implementación de la interfaz para Profesores
    class Profesor implements Enrollable {
        private String especialidad;

        Profesor(String especialidad) {
            this.especialidad = especialidad;
        }

        @Override
        public void inscribirEnCurso(String curso) {
            System.out.println("El Profesor de " + especialidad + " se inscribe en el curso: " + curso);
        }
    }

    // Implementación de la interfaz para Alumnos
    class Alumno implements Enrollable {
        private String especialidad;

        Alumno(String especialidad) {
            this.especialidad = especialidad;
        }

        @Override
        public void inscribirEnCurso(String curso) {
            System.out.println("El Alumno de " + especialidad + " se inscribe en el curso: " + curso);
        }
    }

    // Clase Persona usando composición con Enrollable
    class Persona {
        private Enrollable rol; // Puede ser un Profesor o un Alumno

        Persona(Enrollable rol) {
            this.rol = rol;
        }

        void inscribir(String curso) {
            rol.inscribirEnCurso(curso);
        }
    }

    public class SistemaDeInscripcion {
        public static void main(String[] args) {
            Enrollable profesorMatematicas = new Profesor("Matemáticas");
            Enrollable alumnoFisica = new Alumno("Física");

            Persona profesor = new Persona(profesorMatematicas);
            Persona alumno = new Persona(alumnoFisica);

            profesor.inscribir("Cálculo Avanzado");
            alumno.inscribir("Mecánica Cuántica");
        }
    }

}
