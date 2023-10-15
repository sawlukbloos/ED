/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

/**
 *
 * @author Acer
 */
public class ElementoLista {
    private Tarea tarea;
    private ElementoLista siguiente;

    public ElementoLista(Tarea tarea, ElementoLista siguiente) {
        this.tarea = tarea;
        this.siguiente = siguiente;
    }

    public ElementoLista getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(ElementoLista siguiente) {
        this.siguiente = siguiente;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }
    
    
}
