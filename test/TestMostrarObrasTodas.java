/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Constructores.Libros;
import Constructores.Memorias;
import Constructores.Periodicos;
import Constructores.Revistas;
import Constructores.Tesis;
import InterfazPrestar.MostrarObrasTodas;
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
public class TestMostrarObrasTodas {
 
    MostrarObrasTodas mostOTOD = new MostrarObrasTodas();
    
    public TestMostrarObrasTodas() {
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
    public void getArregloLibros(){
        Libros[] arreglo = mostOTOD.arregloLibros();
        System.out.println(Arrays.toString(arreglo));
    }
    
    public void getArregloMemorias(){
        Memorias[] arreglo = mostOTOD.arregloMemorias();
        System.out.println(Arrays.toString(arreglo));
    }
    
    public void getArregloPeriodicos(){
        Periodicos[] arreglo = mostOTOD.arregloPeriodico();
        System.out.println(Arrays.toString(arreglo));
    }
    
    public void getArregloRevistas(){
        Revistas[] arreglo = mostOTOD.arregloRevistas();
        System.out.println(Arrays.toString(arreglo));
    }
    
    public void getArregloTesis(){
        Tesis[] arreglo = mostOTOD.arregloTesis();
        System.out.println(Arrays.toString(arreglo));
    }
}
