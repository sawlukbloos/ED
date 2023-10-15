/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

/**
 *
 * @author Acer
 */
public class Lista {
    public ElementoLista inicio;
    public ElementoLista fin;

    public Lista(Tarea inicio, Tarea fin) {
     inicio = null;
     fin = null;
    }
    
    public boolean estaVacia(){
        if(inicio==null){
            return true;
        }else{
            return false;
        }
    }
    public void insertarTarea(Tarea tarea){
        ElementoLista actual;
        if(estaVacia()){
            actual = new ElementoLista(tarea, null);
            inicio = actual;
            fin = actual;
        }else{
            actual = new ElementoLista(tarea, null);
            fin.setSiguiente(actual);
            fin = actual;                    
        }
    }
}
