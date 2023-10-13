/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import java.time.LocalDate;

/**
 *
 * @author Acer
 */
public class Tarea {
    
    int Id;
    String Titulo;
    String Descripcion;
    LocalDate fechaVencimiento;

    public Tarea() {
    }

    public Tarea(int Id, String Titulo, String Descripcion, LocalDate fechaVencimiento) {
        this.Id = Id;
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }    
}
