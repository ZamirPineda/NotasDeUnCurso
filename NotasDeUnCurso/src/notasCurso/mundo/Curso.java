/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Desarrollo de Software - Guía 2 - Actividad 2
 * Ejercicio: notas de un curso
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package notasCurso.mundo;

/**
 * Clase que representa un curso.
 */
public class Curso {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Total de estudiantes en el curso.
     */
    public final static int TOTAL_EST = 12;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Notas de los estudiantes.
     */
    private double[] notas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo curso, inicializando todas las notas en cero.
     */
    public Curso() {
        notas = new double[TOTAL_EST];
        for (int i = 0; i < notas.length; i++) {
            notas[i] = 0.0;
        }
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Calcula el promedio del curso.
     *
     * @return Promedio de todas las notas del curso. promedio >= 0.
     */
    public double promedio() {
        double promedio = 0;

        // TODO: Obtener el promedio de las notas de los estudiantes
        for (double nota : notas) { // Recibimos el arreglo de notas[]
            promedio += nota; // En la variable promedio sumamos todas las notas
        }
        promedio /= TOTAL_EST; // Para evitar crear otra instancia, usamos /=

        return promedio;
    }

    /**
     * Devuelve el número de estudiantes que tienen la nota mayor al promedio.
     *
     * @return Número de estudiantes que tienen la nota mayor al promedio. número >= 0.
     */
    public int darCantidadSobrePromedio() {
        // TODO: Calcular el número de notas mayores
        double promedio = promedio(); // Hallar el promedio
        int cantidadSobrePromedio = 0;

        for (double nota : notas) { // Recibimos el arreglo de notas[]
            if (nota > promedio) { // Si la nota es mayor al promedio, la agregamos a cantidadSobrePromedio
                cantidadSobrePromedio++;
            }
        }

        return cantidadSobrePromedio;
    }

    /**
     * Devuelve la nota de un estudiante del curso.
     *
     * @param pNumEstudiante Número del estudiante : 1 <= estudiante <= 12.
     * @return Nota del estudiante.
     */
    public double darNota(int pNumEstudiante) {
        return notas[pNumEstudiante - 1];
    }

    /**
     * Cambia la nota de un estudiante en el curso.
     *
     * @param pNumEstudiante Número del estudiante. 1 <= estudiante <= 12.
     * @param pNota          Nota del estudiante.
     *
     * OJO: La nota debe estar entre 0 y 100
     */
    public void cambiarNota(int pNumEstudiante, double pNota) {
        // TODO: Cambiar la nota del estudiante pNumEstudiante
        // Primero validar que el número de estudiante este entre 1 y el numero de estudiantes
        if (pNumEstudiante >= 1 && pNumEstudiante <= TOTAL_EST && pNota >= 0 && pNota <= 100) { // Luego validar que la nota este entre 0 y 100
            notas[pNumEstudiante - 1] = pNota; // Ingresamos la nota en el estudiante, le restamos 1 por la posición
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------
    /**
     * Obtener la cantidad de estudiantes que no pasaron el curso
     * Recuerde que la nota mínima para pasar el curso es 60.0
     */
    public int cantidadReprobados() {
        // TODO: Obtener la cantidad de estudiantes que no pasaron el curso
        int cantidadReprobados = 0;
        for (double nota : notas) { // Recibimos el arreglo de notas[]
            if (nota < 60.0) { // Si tienen menos de 60.0 reprobaron :v
                cantidadReprobados++;
            }
        }
        return cantidadReprobados;
    }

    /**
     * Obtener la mejor nota del curso.
     */
    public double mejorNota() {
        // TODO: Obtener la mejor nota del curso.
        double mejorNota = 0.0;
        for (double nota : notas) { // Recibimos el arreglo de notas[]
            if (nota > mejorNota) { // Usamos recursividad para poder hallar el valor mayor del arreglo de notas []
                mejorNota = nota;
            }
        }
        return mejorNota;
    }

    /**
     * Obtener el porcentaje de estudiantes que pasaron el curso
     * Debe ser un número entre 0 y 100.
     */
    public double darPorcentajePasaron() {
        // TODO: Obtener el porcentaje de estudiantes que pasaron el curso
        int cantidadPasaron = 0;
        for (double nota : notas) { // Recibimos el arreglo de notas[]
            if (nota >= 60.0) { // Validamos desde 60 para los estudiantes de la EAN
                cantidadPasaron++;
            }
        }
        return (double) cantidadPasaron / TOTAL_EST * 100.0; // Pasamos double por referencia para que no devuelva un entero
    }

    /**
     * Determinar si todos los estudiantes del curso pasaron la materia
     * Retorna true si todos tuvieron notas aprobatorias, o false cuando al menos
     * un estudiante reprobó la materia.
     * Recuerde que para pasar la nota, esta nota debe ser mínimo 60.0
     */
    public boolean todosPasaron() {
        // TODO: Determinar si todos los estudiantes del curso pasaron la materia
        for (double nota : notas) { // Recibimos el arreglo de notas[]
            if (nota < 60.0) { // Si alguno da menos de 60, pues no pasaron todos
                return false;
            }
        }
        return true;
    }
}