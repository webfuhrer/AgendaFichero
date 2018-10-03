/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebasfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class AccesoFichero {
    static String ruta="C:\\agenda\\agenda.csv";
    public static void grabarContacto(Contacto x)
    {
        String linea=x.getNombre()+","+x.getTelefono();
        try {
            FileWriter escritor=new FileWriter(ruta, true);
            escritor.write(linea);
            escritor.write("\n");
            escritor.close();
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static ArrayList<Contacto> obtenerContactos()
    { ArrayList<Contacto> lista=new ArrayList();
    
        try {
           
            FileReader fr=new FileReader(ruta);
            BufferedReader br=new BufferedReader(fr);
            String linea=br.readLine();
            while(linea!=null)
            {
                Contacto c=new Contacto();
               String[] campos=linea.split(",");
               String nombre=campos[0];
               String telefono=campos[1];
               c.setNombre(nombre);
               c.setTelefono(telefono);
               lista.add(c);
               linea=br.readLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoFichero.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
