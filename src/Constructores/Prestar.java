/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Constructores;

import javafx.scene.control.ComboBox;

/**
 *
 * @author UsuarioPC
 */
public class Prestar {
    private String fechaPrestamo;
    private String fechaRetorno;
    private String nombreUnico;
    private String nombreObra;
    private String tipoObra;

    public Prestar(String fechaPrestamo, String fechaRetorno, String nombreUnico, String nombreObra,String tipoObra) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaRetorno = fechaRetorno;
        this.nombreUnico = nombreUnico;
        this.nombreObra = nombreObra;
        this.tipoObra = tipoObra;
    }

    /**
     * @return the fechaPrestamo
     */
    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    /**
     * @param fechaPrestamo the fechaPrestamo to set
     */
    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /**
     * @return the fechaRetorno
     */
    public String getFechaRetorno() {
        return fechaRetorno;
    }

    /**
     * @param fechaRetorno the fechaRetorno to set
     */
    public void setFechaRetorno(String fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    /**
     * @return the nombreUnico
     */
    public String getNombreUnico() {
        return nombreUnico;
    }

    /**
     * @param nombreUnico the nombreUnico to set
     */
    public void setNombreUnico(String nombreUnico) {
        this.nombreUnico = nombreUnico;
    }

    /**
     * @return the nombreObra
     */
    public String getNombreObra() {
        return nombreObra;
    }

    /**
     * @param nombreObra the nombreObra to set
     */
    public void setNombreObra(String nombreObra) {
        this.nombreObra = nombreObra;
    }

    /**
     * @return the tipoObra
     */
    public String getTipoObra() {
        return tipoObra;
    }

    /**
     * @param tipoObra the tipoObra to set
     */
    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }
    
}
