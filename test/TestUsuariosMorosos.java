/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Constructores.Prestar;
import InterfazPrestar.MostrarUsuariosMorosos;
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
public class TestUsuariosMorosos {
    
 
    MostrarUsuariosMorosos mostUsuMoro = new MostrarUsuariosMorosos();
    
    public TestUsuariosMorosos() {
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

    public void cantRegistros(){
        System.out.println(mostUsuMoro.CantidadRegistrosUsuarios());
    }
    
    public void arregloObrasPrestadas(){
        Prestar[] arreglo = mostUsuMoro.arregloObrasPrestadas();
        System.out.println(Arrays.toString(arreglo));
    }
}