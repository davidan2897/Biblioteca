/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Constructores.Prestar;
import Interfaces.Catalogo.UtilidadesGestionar;
import InterfazPrestar.PrestarObras;
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
public class TestPrestarObras {
  PrestarObras prestOb = new PrestarObras();
    
    public TestPrestarObras() {
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
        System.out.println(prestOb.CantidadRegistrosUsuarios());
    }
    
    public void arregloObrasPrest(){
        Prestar[] arreglo = prestOb.arregloObrasPrestadas();
        System.out.println(Arrays.toString(arreglo));
    }
    
    public void Agregar(){
        String fechaPrestamo="12/4/2018",fechaRetorno="17/4/2018",nombreUnico="Michelle",nombreObra="sassaad3",tipoObra="dfgk";
        Prestar prest = new Prestar(fechaPrestamo, fechaRetorno, nombreUnico, nombreObra, tipoObra);
    }
    
    public void ModificarEstObra(){
        UtilidadesGestionar utilGestionar = new UtilidadesGestionar();
        prestOb.verficaEstadoObra(utilGestionar.getArreglo(utilGestionar.CantidadRegistros("Revistas.txt"),
                    "Revistas"), "Revistas.txt", "Playboy");
    }
    
    public void VerificaEstadoObra(){
        UtilidadesGestionar utilGestionar = new UtilidadesGestionar();
        prestOb.verficaEstadoObra(utilGestionar.getArreglo(utilGestionar.CantidadRegistros("Revistas.txt"),"Revistas"), "Revistas.txt", "Playboy");
    } 
}
