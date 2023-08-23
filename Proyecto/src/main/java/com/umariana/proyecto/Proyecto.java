/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.umariana.proyecto;
import Mundo.Alumno;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sistemas (David Noguera y Samuel Bolaños)
 */
public class Proyecto {
    
    
    public static void main(String[] args) {
        
        //Duncion que permite leer la opcion del usuario
        Scanner lector= new Scanner(System.in);
        //Bandera para terminar el programa
        boolean activo = true;
        ArrayList<Alumno> misAlumnos = new ArrayList<Alumno>();
        
        
        do{
        System.out.println("--------Menu de opeciones--------");
        System.out.println("1. Insertar alumno");
        System.out.println("2. Eliminar alumno");
        System.out.println("3. Modificar alumno");
        System.out.println("4. Consultar alumno");
        System.out.println("5. Generar reporte por semestre");
        System.out.println("6. Terminar programa");    
        System.out.println("----------------------------------");
        
        // Empleamos un switch para la seleccion de las opciones
        int opcion = lector.nextInt();
        
            switch (opcion) {
                
                case 1:
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
                    // Se agrega el valor del objeto al list array
                    
                    misAlumnos.add(a);
                    
                    System.out.println("Alumno registrado satisfactoriamente");
                    System.out.println("---------------------------");
                    break;
                    
                case 2:
                    System.out.println("--------Eliminar Alumno--------");
                    
                    // Para eliminar un alumno emplearemos su cedula
                    // Y emplearemos un ciclo "for" con un boolean el cual busque la cedula introducidad
                    
                    System.out.println("Ingrese el numero de cedula del alumno que desea modificar");
                    int cedulaE = lector.nextInt();
                    boolean buscar = false; 
                    
                    for (int i = 0; i < misAlumnos.size(); i++) {
                        
                        if (misAlumnos.get(i).getCedula() == cedulaE){
                        
                            misAlumnos.remove(i);
                            System.out.println("Se elimino el alumno con la siguiente cedula: " + cedulaE);
                            buscar = true;
                            break;
                        } 
                        
                        if (!buscar) {
                            System.out.println("No se encontro un alumno con la cedula: " + cedulaE);
                        }
                        
                        if (misAlumnos.isEmpty()) {
                           System.out.println("No hay alumnos registrados.");
                        }
                    
                    }
                    System.out.println("---------------------------");
                    break;
                    
                case 3:
                    System.out.println("--------Modificar datos de alumno--------");
                    
                    // Para modificar los datos de un alumno emplearemos su cedula
                    // Y emplearemos un ciclo "for" con un boolean el cual busque la cedula introducidad similar a la opcion 2
                    
                    System.out.println("Ingrese el numero de cedula del alumno que desea modificar");
                    int cedulaM = lector.nextInt();
                    boolean modificar = false; 
                    
                    for (int i = 0; i < misAlumnos.size(); i++) {
                        
                        if (misAlumnos.get(i).getCedula() == cedulaM){
                            
                            // Se empleara un switch para seleccionar que dato quiere modificarse
                            Alumno alumnoModificado = misAlumnos.get(i);

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
                            
                            System.out.println("Se modificaron los datos del alumno con la siguiente cedula: " + cedulaM);
                            buscar = true;
                            break;
                        } 
                        
                        if (!modificar) {
                            System.out.println("No se encontro un alumno con la cedula: " + cedulaM);
                        } 
                        
                        if (misAlumnos.isEmpty()) {
                           System.out.println("No hay alumnos registrados.");
                        }
                    }
                    
                    break;
                    
                case 4:
                    System.out.println("--------Consultar Alumnos--------");
                    
                    // Para consultar los alumnos utilizaremos un ciclo for each
                    // Tambien se adiciona un "if" por si no hay un registro existentes
                     
                    if (misAlumnos.isEmpty()) {
                         System.out.println("No hay alumnos registrados.");
                    } else {
                          // Los datos que "i" recibe son de tipo "Alumno" y el ciclo se repite dependiendo de cuantos elementos hay en el arreglo
                          
                         for (Alumno i : misAlumnos) {
                          System.out.println("Cédula: " + i.getCedula());
                          System.out.println("Nombre: " + i.getNombre());
                          System.out.println("Apellido: " + i.getApellido());
                          System.out.println("Semestre: " + i.getSemestre());
                          System.out.println("Correo: " + i.getCorreo());
                          System.out.println("Celular: " + i.getCelular());
                          System.out.println("---------------------------");
                        }
                     } 
                    break;
                    
                    
                case 5:
                    // Se generara un archivo el cual contenga el registro de los estudiantes de un determinado semestre
                    System.out.println("--------Generar reporte semestre--------");
                    System.out.println("Ingrese el semestre del cual necesite una lista");
                    
                    int semestreS = lector.nextInt();
                    
                    //Se empleara un try and catch para la generacion del archivo 
                    try {
                            // El archivo se va a almacenar en la carpteta data
                            File archivo = new File ("./data/reporteEstudiantes" + semestreS + ".txt") ;
                            
                            PrintWriter pluma = new PrintWriter(archivo);
                            pluma.println("Reporte de estudiantes semestre: " + semestreS);
                            pluma.println("-----------------------");
                            
                            

                            Iterator<Alumno> iterator = misAlumnos.iterator();
                            while (iterator.hasNext()) {
                                Alumno alumno = iterator.next();
                                if (alumno.getSemestre() == semestreS) {
                                    pluma.println("Cédula: " + alumno.getCedula() );
                                    pluma.println("Nombre: " + alumno.getNombre() );
                                    pluma.println("Apellido: " + alumno.getApellido() );
                                    pluma.println("Semestre: " + alumno.getSemestre() );
                                    pluma.println("Correo: " + alumno.getCorreo() );
                                    pluma.println("Celular: " + alumno.getCelular() );
                                    pluma.println("---------------------------");
                                } 
                            }

                            pluma.close();
                            System.out.println("Archivo generado exitosamente: reporteEstudiantes" + semestreS + ".txt");
                        } catch (IOException e) {
                            System.out.println("Error al generar el archivo: " + e.getMessage());
                        }
                 
                    
                    break;

                    case 6:
                    
                    // Para finalizar el programa emplearemos el boolean (activo) previamente creado
                    System.out.println("--------Terminar Programa--------");
                    System.out.println("Esta seguro de querer terminar el programa");
                    
                    // Se coloca un "if" por si se quiere continuar utilizando el programa
                    // Adicionalmente empleamos "equalsIgnoreCase()" para ignorar diferencias de minusculas y mayusculas
                    
                    String x = lector.next();
                        if (x.equalsIgnoreCase("Si")) {
                             System.out.println("Fin del programa");
                             activo = false;  // 
                        } else if (x.equalsIgnoreCase("No")) {
                             System.out.println("Continuando");
                        } else {
                             System.out.println("Respuesta inválida. Continuando");
                        }  
                    System.out.println("---------------------------");
                    break;
                    
            default:
                    System.out.println("Debe seleccionar una opcion del menu");
            }
        
        
        } while (activo);
        
        
    }
}
        
