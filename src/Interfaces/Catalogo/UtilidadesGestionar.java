/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class UtilidadesGestionar {
    
     public int CantidadRegistros(String nombreArchivo) {//cuenta la cantidad de lineas que tiene el registro
        int cuentaRegistro = 0;
        try {
            BufferedReader br = getBufferedReader(nombreArchivo);
            String registro = br.readLine();
            while (registro != null) {
                cuentaRegistro++;
                registro = br.readLine();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "error");
        }
        return cuentaRegistro;
    } 
      public BufferedReader getBufferedReader(String nombrearchivo) {
        File archivo = new File(nombrearchivo);
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "error");
        }
        return br;
}
      public void eliminar(String titulo, String a[],String nombreArchivo) {
         String Objeto="", titutloArchivo; 
       try{
           PrintStream ps = new PrintStream(nombreArchivo);

            for (int i = 0; i < a.length; i++) {
                  Objeto= a[i];
               StringTokenizer sT = new StringTokenizer( Objeto, ";");
                 titutloArchivo =sT.nextToken();
                 
                 
                if (titulo.equals(titutloArchivo)){ 
                   
                   Objeto = "-1";
                }
                if(!Objeto.equalsIgnoreCase("-1"))
                  ps.println(Objeto);
         
            }//fin for
           
     

    }//try//try
      
       catch(FileNotFoundException fnf){
                JOptionPane.showMessageDialog(null, "Un error ha pasado: Contacte con su administrador."); 
    }//fin catch
    

      }
      public boolean buscar(String titulo, String a[]) {
        String tituloArchivo = "",fechaIngreso="",autor ="", aux = "";

        boolean encontrado = false;
        for (int i = 0; i < a.length; i++) {
            aux = a[i];

            StringTokenizer st = new StringTokenizer(aux, ";");

            tituloArchivo = st.nextToken();

            if (titulo.equals(tituloArchivo)) {
                encontrado = true;
                fechaIngreso = st.nextToken();
                autor = st.nextToken();
                break;
              
                
            }//fin if

        }//fin for i

        return encontrado;
    }//fin buscar
      
       public String[] getArreglo(int cantidadRegistros, String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        String array[] = new String[cantidadRegistros];
        String c;
        int i = 0;
        try {
            BufferedReader br = getBufferedReader(nombreArchivo);
            c = br.readLine();

            while (i < cantidadRegistros) {
                array[i] = c;
                c = br.readLine();
                i++;
            }//fin while

        }//fin try
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas");

        }

        return array;

    }//fin getArreglo
}