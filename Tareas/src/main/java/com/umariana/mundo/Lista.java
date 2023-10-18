/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletContext;

/**
 *
 * @author Acer
 */
public class Lista {
    public Nodo inicio;
    public Nodo fin;

    public Lista() {
    }

    public Lista(Tarea inicio, Tarea fin) {
     inicio = null;
     fin = null;
    }
    
    public boolean verificarContenido(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
    public void agregarTareaAlInicio(Tarea nuevaTarea){
        Nodo nuevo;
        if(verificarContenido()){
            nuevo = new Nodo(nuevaTarea, null);
            inicio = nuevo;
            fin = nuevo;
        }else{
            nuevo = new Nodo(nuevaTarea, null);
            fin.setSiguiente(nuevo);
            fin = nuevo;                    
        }
    }
    public void cargarLista(Lista listaTareas, ServletContext context) {
        //Ruta del archivo
        String filePath = context.getRealPath("/data/tareas.txt");
        File archivo = new File(filePath);

        try (PrintWriter writer = new PrintWriter(archivo)) {
            Nodo temp = listaTareas.inicio;
            
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            while (temp != null) {
                Tarea tarea = temp.getTarea();
                //Para escribir correctamente la linea, tenemos que corvertir el tipo de dato  de la fecha de Date a String
                String fechaFormateada = formato.format(tarea.getFechaDeVencimiento());
                writer.println(tarea.getId() + ","
                        + tarea.getTitulo() + ","
                        + tarea.getDescripcion() + "," 
                        + fechaFormateada);
                temp = temp.getSiguiente();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public void agregarTareaAntesDe(String titulo, Tarea nuevaTarea) {
    Nodo nodoAnterior = null;
    Nodo nodoActual = inicio;

    if (inicio == null) {
        System.out.println("No hay tareas agregadas.");
    } else {
        while (nodoActual != null && !nodoActual.getTarea().getTitulo().equals(titulo)) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente(); 
        }

        if (nodoActual != null) {
            Nodo nuevoNodo = new Nodo(nuevaTarea, nodoActual); 

            if (nodoAnterior != null) {
                nodoAnterior.setSiguiente(nuevoNodo);
            } else {
                inicio = nuevoNodo;
            }
        } else {
            System.out.println("La tarea no se encontró en la lista.");
        }
    }
}
public void agregarTareaDespuesDe(String titulo, Tarea nuevaTarea) {
    Nodo nodoActual = inicio;

    if (inicio == null) {
        System.out.println("No hay tareas agregadas.");
    } else {
        while (nodoActual != null && !nodoActual.getTarea().getTitulo().equals(titulo)) {
            nodoActual = nodoActual.getSiguiente(); 
        }

        if (nodoActual != null) {
            Nodo nuevoNodo = new Nodo(nuevaTarea, nodoActual.getSiguiente());

            nodoActual.setSiguiente(nuevoNodo);
        } else {
            System.out.println("La tarea no se encontró en la lista.");
        }
    }
}



    
    public Tarea LocalizarAnteriorTarea(String titulo) {
    Nodo nodoAnterior = null;
    Nodo nodoActual = inicio;
    
    while (nodoActual != null && !nodoActual.getTarea().getTitulo().equals(titulo)) {
        nodoAnterior = nodoActual;
        nodoActual = nodoActual.getSiguiente();
    }
    
    if (nodoAnterior != null) {
        return nodoAnterior.getTarea();
    } else {
        // Manejar el caso en el que no se encuentra la tarea anterior
        return null;
    }
}

    /**
     * Metodo para leer el archivo de texto
     * @param context
     * @return 
     */
    public static Lista leerArchivo(ServletContext context) {
        // Ruta relativa
        String rutaRelativa = "/data/tareas.txt";
        // Ruta absoluta
        String rutaAbsoluta = context.getRealPath(rutaRelativa);

        File file = new File(rutaAbsoluta);
        Lista listaA = new Lista();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] atributos = linea.split(",");
                if (atributos.length == 4) {
                    int id = Integer.parseInt(atributos[0]);
                    String titulo = atributos[1];
                    String descripcion = atributos[2];
                    String fechaVencimiento = atributos[3];

                    DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        // Conversión de String a Date
                        Date fechaConvertida = formato.parse(fechaVencimiento);
                        // Agregar la tarea con la fecha convertida
                        Tarea tarea = new Tarea(id, titulo, descripcion, fechaConvertida);
                        listaA.agregarTareaAlInicio(tarea);
                    } catch (ParseException e) {
                        // Manejo de la excepción de análisis de fecha aquí
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            // Manejo de la excepción de E/S aquí
            e.printStackTrace();
        }
        return listaA;
    }
}
