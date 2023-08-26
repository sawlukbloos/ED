/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;

import Mundo.Alumno;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sistemas (David Noguera y Samuel Bolaños)
 */
public class Proyecto {

    public static void main(String[] args) {

        //Funcion que permite leer la opcion del usuario
        Scanner lector = new Scanner(System.in);
        //Bandera para terminar el programa
        boolean activo = true;
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();

        do {
            mostrarMenu();

            int opcion = lector.nextInt();
            // Usamos un switch para la seleccion de las opciones
            switch (opcion) {

                case 1:

                    crearNuevoAlumno(misAlumnos, lector);

                    break;

                case 2:

                    eliminarAlumno(misAlumnos, lector);

                    break;

                case 3:

                    modificarAlumno(misAlumnos, lector);

                    break;

                case 4:

                    consultarAlumnos(misAlumnos);

                    break;
                case 5:

                    generarReporteSemestre(misAlumnos, lector);

                    break;

                case 6:

                    activo = !terminarPrograma(lector);
                    System.out.println("---------------------------");

                    break;

                default:
                    System.out.println("Debe seleccionar una opcion del menu");
            }

        } while (activo);
    }
    public static void mostrarMenu() {

        System.out.println("--------Menu de opeciones--------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Consultar alumno");
        System.out.println("5. Generar reporte por semestre");
        System.out.println("6. Terminar programa");
        System.out.println("----------------------------------");
    }
    public static void crearNuevoAlumno(ArrayList misAlumnos, Scanner lector) {

        System.out.println("--------Crear Nuevo Alumno--------");

        System.out.println("Introduce la cedula del alumno");
        int cedula = lector.nextInt();

        System.out.println("Introduce el nombre del alumno");
        String nombre = lector.next();

        System.out.println("Introduce el apellido del alumno");
        String apellido = lector.next();

        System.out.println("Introduce el semestre del alumno");
        int semestre = lector.nextInt();

        System.out.println("Introduce el correo del alumno");
        String correo = lector.next();

        System.out.println("Introduce el celular del alumno");
        int celular = lector.nextInt();

        //Se crea un objeto para guardar la informacion de cada alumno
        Alumno a = new Alumno();

        a.setCedula(cedula);
        a.setNombre(nombre);
        a.setApellido(apellido);
        a.setSemestre(semestre);
        a.setCorreo(correo);
        a.setCelular(celular);
        // Se agrega los datos del objeto al list array

        misAlumnos.add(a);

        System.out.println("Alumno registrado satisfactoriamente");
        System.out.println("---------------------------");

    }

    public static void eliminarAlumno(ArrayList misAlumnos, Scanner lector) {
        System.out.println("--------Eliminar Alumno--------");

        System.out.println("Ingrese el número de cédula del alumno que desea eliminar");
        int cedulaE = lector.nextInt();
        boolean buscar = false; 

        Iterator<Alumno> iterador = misAlumnos.iterator();

        while (iterador.hasNext()) {
            Alumno alumno = iterador.next();

            if (alumno.getCedula() == cedulaE) {
                iterador.remove();
                System.out.println("Se eliminó el alumno con la siguiente cédula: " + cedulaE);
                buscar = true;
                break;
            }
        }

        if (!buscar) {
            System.out.println("No se encontró un alumno con la cédula: " + cedulaE);
        }

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        }

        System.out.println("---------------------------");
    }

    public static void modificarAlumno(ArrayList<Alumno> misAlumnos, Scanner lector) {
        System.out.println("--------Modificar datos de alumno--------");

        System.out.println("Ingrese el número de cédula del alumno que desea modificar");
        int cedulaM = lector.nextInt();
        boolean modificar = false;

        Iterator<Alumno> iterador = misAlumnos.iterator();

        while (iterador.hasNext()) {
            Alumno alumnoModificado = iterador.next();

            if (alumnoModificado.getCedula() == cedulaM) {
                System.out.println("Seleccione el dato que desea modificar:");
                System.out.println("1. Nombre");
                System.out.println("2. Apellido");
                System.out.println("3. Semestre");
                System.out.println("4. Correo");
                System.out.println("5. Celular");
                int opcionDato = lector.nextInt();

                switch (opcionDato) {
                    case 1:
                        System.out.println("Introduzca nuevo nombre del alumno:");
                        String nuevoNombre = lector.next();
                        alumnoModificado.setNombre(nuevoNombre);
                        break;
                    case 2:
                        System.out.println("Introduzca nuevo apellido del alumno:");
                        String nuevoApellido = lector.next();
                        alumnoModificado.setApellido(nuevoApellido);
                        break;
                    case 3:
                        System.out.println("Introduzca nuevo semestre del alumno:");
                        int nuevoSemestre = lector.nextInt();
                        alumnoModificado.setSemestre(nuevoSemestre);
                        break;
                    case 4:
                        System.out.println("Introduzca nuevo correo del alumno:");
                        String nuevoCorreo = lector.next();
                        alumnoModificado.setCorreo(nuevoCorreo);
                        break;
                    case 5:
                        System.out.println("Introduzca el nuevo celular del alumno:");
                        int nuevoCelular = lector.nextInt();
                        alumnoModificado.setCelular(nuevoCelular);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }

                System.out.println("Se modificaron los datos del alumno con la siguiente cédula: " + cedulaM);
                modificar = true;
                break;
            }
        }

        if (!modificar) {
            System.out.println("No se encontró un alumno con la cédula: " + cedulaM);
        }

        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        }

        System.out.println("---------------------------");
    }

    public static void consultarAlumnos(ArrayList<Alumno> misAlumnos) {
        System.out.println("--------Consultar Alumnos--------");

        // Para consultar los alumnos utilizaremos un ciclo for each
        // Tambien se adiciona un "if" por si no hay un registro existentes
        if (misAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
        } else {
            // Los datos que "i" recibe son de tipo "Alumno" y el ciclo se repite dependiendo de cuantos elementos hay en el arreglo

            for (Alumno alumno : misAlumnos) {
                System.out.println("Cédula: " + alumno.getCedula());
                System.out.println("Nombre: " + alumno.getNombre());
                System.out.println("Apellido: " + alumno.getApellido());
                System.out.println("Semestre: " + alumno.getSemestre());
                System.out.println("Correo: " + alumno.getCorreo());
                System.out.println("Celular: " + alumno.getCelular());
                System.out.println("---------------------------");
            }
        }
    }

    public static void generarReporteSemestre(ArrayList misAlumnos, Scanner lector) {
        // Se generara un archivo el cual contenga el registro de los estudiantes de un determinado semestre
        System.out.println("--------Generar reporte semestre--------");
        System.out.println("Ingrese el semestre del cual necesite una lista");

        int semestreS = lector.nextInt();

        //Se empleara un try and catch para la generacion del archivo 
        try {
            // El archivo se va a almacenar en la carpteta data
            File archivo = new File("./data/reporte" + semestreS + ".txt");

            PrintWriter pluma = new PrintWriter(archivo);
            pluma.println("Reporte de estudiantes semestre: " + semestreS);
            pluma.println("-----------------------");

            Iterator<Alumno> iterator = misAlumnos.iterator();
            while (iterator.hasNext()) {
                Alumno alumno = iterator.next();
                if (alumno.getSemestre() == semestreS) {
                    pluma.println("Cédula: " + alumno.getCedula());
                    pluma.println("Nombre: " + alumno.getNombre());
                    pluma.println("Apellido: " + alumno.getApellido());
                    pluma.println("Semestre: " + alumno.getSemestre());
                    pluma.println("Correo: " + alumno.getCorreo());
                    pluma.println("Celular: " + alumno.getCelular());
                    pluma.println("---------------------------");
                }
            }

            pluma.close();
            System.out.println("Archivo generado exitosamente: reporteEstudiantes" + semestreS + ".txt");
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }         

    public static boolean terminarPrograma(Scanner lector) {

        // Para finalizar el programa emplearemos el boolean (activo) previamente creado
        System.out.println("--------Terminar Programa--------");
        System.out.println("¿Está seguro de querer terminar el programa? (Si/No)");

        String respuesta = lector.next();

        if (respuesta.equalsIgnoreCase("Si")) {
            System.out.println("Fin del programa");
            return true;
        } else if (respuesta.equalsIgnoreCase("No")) {
            System.out.println("Continuando");
            return false;
        } else {
            System.out.println("Respuesta inválida. Continuando");
            return false;
        }
    }
}
