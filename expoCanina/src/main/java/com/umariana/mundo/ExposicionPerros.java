/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.umariana.mundo;

import com.sun.tools.classfile.Dependencies;
import com.umariana.mundo.Perro;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import static jdk.jpackage.internal.Arguments.CLIOptions.context;

/**
 *
 * @author Sistemas
 */
public class ExposicionPerros {

    ArrayList<Perro> darPerros = new ArrayList<>();

    // Método para guardar la lista de perros en un archivo perros.ser
    public static void guardarPerro(ArrayList<Perro> darPerros, ServletContext context) throws IOException {
        //Definimos una ruta para buscar nuestro archivo perro.ser
        String relativePath = "/data/perros.ser";
        String absPath = context.getRealPath(relativePath);
        File archivo = new File(absPath);
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
    public static ArrayList<Perro> cargarPerros(ServletContext context) throws IOException, ClassNotFoundException {
        //Reutilizamos la ruta previamente definida para perro.ser
        String relativePath = "/data/perros.ser";
        String absPath = context.getRealPath(relativePath);
        File archivo = new File(absPath);
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
