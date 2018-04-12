/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores;

import java.io.PrintStream;

/**
 *
 * @author David
 */
public class Periodicos extends Catalogo {
    
    private String codigoISSN;
    private String edicion;
    private String fecha;
    
    public Periodicos(String titulo, String fechaIngreso, String Autor,String codigoISSN,String edicion,String fecha,String Estado) {
        super(titulo, fechaIngreso, Autor,Estado);
        this.codigoISSN=codigoISSN;
        this.edicion=edicion;
        this.fecha=fecha;
    }
     public void Agregar(Periodicos periodicos) {
		// TODO Auto-generated method stub
	 PrintStream ps = getPrintStream("Periodicos.txt");

        ps.println(periodicos.getTitulo() + ";" + periodicos.getFechaIngreso()+ ";" + periodicos.getAutor()+ ";" + periodicos.getCodigoISSN() + ";" + periodicos.getEdicion()+";"+periodicos.getFecha()+";"+periodicos.getEstado());
	}
    


    public String getCodigoISSN() {
        return codigoISSN;
    }

    public void setCodigoISSN(String codigoISSN) {
        this.codigoISSN = codigoISSN;
    }

    public String getEdicion() {
        return edicion;
    }

    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
