/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;

/**
 *
 * @author Acer
 */
public class Lista {
    public ElementoLista inicio;
    public ElementoLista fin;

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
    public void agregarTarea(Tarea tarea){
        ElementoLista actual;
        if(verificarContenido()){
            actual = new ElementoLista(tarea, null);
            inicio = actual;
            fin = actual;
        }else{
            actual = new ElementoLista(tarea, null);
            fin.setSiguiente(actual);
            fin = actual;                    
        }
    }
    public void cargarLista(Lista listaActualizada, ServletContext context) {
        String filePath = context.getRealPath("/data/tareas.txt");
        File file = new File(filePath);

       try (PrintWriter writer = new PrintWriter(file)) {
            ElementoLista temp = listaActualizada.inicio;
            while (temp != null) {
                Tarea tarea = temp.getTarea();
                writer.println(tarea.getId() + "," + tarea.getTitulo() + "," + tarea.getDescripcion() + "," + tarea.getFechaVencimiento());
                temp = temp.getSiguiente();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Lista leerLista(ServletContext context) {
        String filePath = context.getRealPath("/data/tareas.txt");
        File file = new File(filePath);
        Lista lista = new Lista();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] atributos = line.split(",");
                if (atributos.length == 4) {
                    int id = Integer.parseInt(atributos[0]);
                    String titulo = atributos[1];
                    String descripcion = atributos[2];
                    String fechaVencimiento = atributos[3];

                    Tarea tarea = new Tarea(id, titulo, descripcion, fechaVencimiento);
                    lista.agregarTarea(tarea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
