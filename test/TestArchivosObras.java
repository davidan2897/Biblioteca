/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.Catalogo.ArchivosObras;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michelle
 */
public class TestArchivosObras {
    
    ArchivosObras ao= new ArchivosObras();
    public TestArchivosObras() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    public void agregarLibros() {
    String titulo="Quijote", fechaIngreso="2/3/18", autor="Pedro", codigoISBN="2136458745", tema="Aventura", subtema="Enseñanza";
    ao.agregarLibros(titulo, fechaIngreso, autor, codigoISBN, tema, subtema, true);
    }
   // @Test
    public void agregarMemorias(){
        String titulo="", fechaIngreso="",autor="",resumen="", Abstract="",conferecinaPresentada="";
        ao.agregarMemorias(titulo, fechaIngreso, autor, resumen, Abstract, conferecinaPresentada, true);
    }
    //@Test
    public void agregarRevistas(){
        String titulo="", fechaIngreso="", autor="", codigoISSN="", edicion="";
        ao.agregarRevistas(titulo, fechaIngreso, autor, codigoISSN, edicion, true);
    }
   //@Test 
   public void agregarPeriodicos(){
        String titulo="",fechaIngreso="", autor="", codigoISSN="", edicion="",fecha="";
        ao.agregarPeriodicos(titulo, fechaIngreso, autor, codigoISSN, edicion, fecha, true);
    }
//@Test
public void agregarTesis(){
    String titulo="",fechaIngreso="", autor="", codigoISSN="", edicion="",fecha="";
    ao.agregarTesis(titulo, fechaIngreso, autor, fecha, autor, true);
    
}
//@Test
public void getNombreArchivo(){
      String nombre="",archivo="Usuarios.txt";
        int Lugar=0, contador=0;
        BufferedReader br = ao.getBufferedReader(archivo);
        try {
            String registroActual = br.readLine();

            while (registroActual != null) {
                System.out.println(ao.getNombreArchivo(registroActual, Lugar));
                registroActual = br.readLine();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }
        System.out.println(nombre);
}  
    
   // @Test
   public void getArregloArchivo(){
        String archivo = "Usuarios.txt";
        System.out.println(Arrays.toString(ao.getArregloArchivo(archivo)));
   }
//   @Test
    public void existeLibro(){
       String identificador="", archivo="";
        if(ao.existeObra(identificador, archivo))
            System.out.println("Obra Encontrado");
        else System.out.println("Obra No Encontrado");
    }

     //@Test
    public void getDatosEspecíficos(){
        String archivo="", identificador="";
        System.out.println(ao.getDatosEspecificos(archivo, identificador));
    }    
    
//    @Test
    public void actualizarLibro(){
        String titulo="", fechaIngreso="", autor="", codigoISBN="",  tema="", subtema="";
      ao.actualizarLibro(titulo, fechaIngreso, autor, codigoISBN, tema, subtema);
    }

//     @Test
    public void actualizarMemorias(){
        String titulo="", fechaIngreso="", autor="", resumen="", Abstract="", conferecinaPresentada="";
        ao.actualizarMemoria(titulo, fechaIngreso, autor, resumen, Abstract, conferecinaPresentada);
        
    }
  
}
