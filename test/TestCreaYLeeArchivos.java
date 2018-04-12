/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.Catalogo.CreayLeeArchivos;
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
public class TestCreaYLeeArchivos {
    
   
     CreayLeeArchivos cyla = new CreayLeeArchivos();
    
    public TestCreaYLeeArchivos() {
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

    
    @Test
    public void agregarUsuario(){
       String unicoNombre="Mich",nombre="Michelle",contraseña="1234",tipoIdentificacion="Nacional",identificacion="456";
        cyla.agregarUsuario(unicoNombre,nombre,contraseña,tipoIdentificacion,identificacion,true);
    }
    
    //@Test
    public void getNombreArchivo(){
        String nombre="",archivo="Usuarios.txt";
        int Lugar=0, contador=0;
        BufferedReader br = cyla.getBufferedReader(archivo);
        try {
            String registroActual = br.readLine();

            while (registroActual != null) {
                System.out.println(cyla.getNombreArchivo(registroActual, Lugar));
                registroActual = br.readLine();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }
        System.out.println(nombre);
    }
    
    //@Test
    public void CantidadRegistros(){
        
        System.out.println(cyla.CantidadRegistrosUsuarios());
        
    }
    
    //@Test
    public void getArregloArchivo(){
        
        String archivo = "Usuarios.txt";
        System.out.println(Arrays.toString(cyla.getArregloArchivo(archivo)));
        
    }
    
    //@Test
    public void existeUsuario(){
        String usuarioABuscar = "Robert", archivo = "Usuarios.txt";
        if(cyla.existeUsuario(usuarioABuscar, archivo))
            System.out.println("Usuario Encontrado");
        else System.out.println("Usuario No Encontrado");
    }
    
    //@Test
    public void getDatosEspecíficos(){
        String archivo="Usuarios.txt", nombreABuscar="picado";
        System.out.println(Arrays.toString(cyla.getDatosEspecificos(archivo, nombreABuscar)));
    }
    
    @Test
    public void actualizarUsuario(){
        String identificacion="a",nombreUnico="Anastasia",nombreCompleto="Anastasia Grey",contraseña="castigo",tipoUsuario="Sumisa",tipoIdentificacon="Nacional";
        cyla.actualizarUsuario(identificacion, nombreUnico, nombreCompleto, contraseña, tipoUsuario, tipoIdentificacon);
    }
}
