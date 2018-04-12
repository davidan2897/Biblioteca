/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Interfaces.Catalogo.UtilidadesGestionar;
import java.util.Arrays;
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
public class TestUtilidadesGestionar {
    UtilidadesGestionar ug= new  UtilidadesGestionar();
    
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
    public void cantidadRegistros() {
    System.out.println(ug.CantidadRegistros("Usuarios.txt"));
    }
    
    
     @Test
    public void eliminar(){
        ug.eliminar("revista", ug.getArreglo(ug.CantidadRegistros("Revistas.txt"), "Revistas.txt"), "Revistas.txt");
    }
    
     @Test
    public void buscar(){
         System.out.println(ug.buscar("revista", ug.getArreglo(ug.CantidadRegistros("Revistas.txt"), "Revistas.txt")));
    }
    
    @Test
    public void getArreglo(){
      String arreglo[] =  ug.getArreglo(ug.CantidadRegistros("Revistas.txt"), "Revistas.txt");
      System.out.println(Arrays.toString(arreglo));
    }
}
