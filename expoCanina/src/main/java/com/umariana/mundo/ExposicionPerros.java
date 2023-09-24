/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import com.umariana.mundo.Perro;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.servlet.ServletContext;

/**
 *
 * @author Sistemas
 */
public class ExposicionPerros {

    ArrayList<Perro> darPerros = new ArrayList<>();

    // Método para guardar la lista de perros en un archivo perros.ser
    public static void guardarperro(ArrayList<Perro> darPerros) {
        try {
            // Crear un archivo para guardar la lista de perros serializada
            FileOutputStream fos = new FileOutputStream("perros.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(darPerros);
            oos.close();
            System.out.println("Datos de perros guardados exitosamente en: perros.ser");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los datos de perro: " + e.getMessage());
        }
    }

    // Método para cargar los perros desde el archivo deserializándolo
    public static ArrayList<Perro> cargarPerros(ServletContext servletContext) {
        ArrayList<Perro> darPerros = new ArrayList<>();
        try {
            // Cargar la lista de perros desde el archivo
            FileInputStream fis = new FileInputStream("perros.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            darPerros = (ArrayList<Perro>) ois.readObject();
            ois.close();
            System.out.println("Datos de perros cargados exitosamente desde: perros.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al cargar los datos de perros: " + e.getMessage());
        }
        return darPerros;
    }

}
