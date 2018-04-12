/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import Constructores.Periodicos;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author UsuarioPC
 */
public class GestionarPeriodico {
//instancias globales
    public String titulo;
    public String autor;
    static String codigoIssn;
    public String Edicion;
    public String fechaIngreso;
    public String fechaPeriodico;
    public String Estado;
    TextField texfieldTituloPeriodico;
    TextField textfieldAutor;
    TextField textfieldCodigoIssn;
    TextArea textareaEdicion;
    TextField fecha;
    Button btnAgregar;
    DatePicker datepickerFecha;
    String tituloAux, nombreArchivo = "Periodicos.txt";
UtilidadesGestionar utilGestionar = new UtilidadesGestionar();

    public GridPane AgregarPeriodico(){
    GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
         datepickerFecha = new DatePicker();
        Label labelTituloPeriodico = new Label("Titulo");
        gpVentanaLibros.add(labelTituloPeriodico, 0, 0);
        texfieldTituloPeriodico = new TextField();
        gpVentanaLibros.add(texfieldTituloPeriodico, 1, 0);
        Label labelAutor= new Label("Autor");
        gpVentanaLibros.add(labelAutor, 0, 1);
         textfieldAutor= new TextField();
        gpVentanaLibros.add(textfieldAutor, 1, 1);
        Label codeIssn = new Label("Código ISSN");
        gpVentanaLibros.add(codeIssn, 0, 2);
         textfieldCodigoIssn = new TextField();
        gpVentanaLibros.add(textfieldCodigoIssn, 1, 2);
        Label labelEdicion = new Label("Edición");
        gpVentanaLibros.add(labelEdicion, 0, 3);
        textareaEdicion = new TextArea();
         gpVentanaLibros.add(textareaEdicion, 1, 3);
        Label labelfecha = new Label("Fecha de Publicación");
        gpVentanaLibros.add(labelfecha, 0, 4);
         fecha= new TextField();
       gpVentanaLibros.add(fecha, 1, 4);
         Label labelFechaingreso = new Label("Fecha de ingreso");
        gpVentanaLibros.add(labelFechaingreso, 0, 5);
         gpVentanaLibros.add(datepickerFecha,1,5);
//        Msj = new Label("");
           gpVentanaLibros.add(btnAgregar, 0, 6);
         textareaEdicion.setPrefWidth(100);
         textareaEdicion.setPrefHeight(100);
        
        
         datepickerFecha.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datepickerFecha.getValue();
                int dia = date.getDayOfMonth();
                int mes=date.getMonthValue();
                int año=date.getYear();
                fechaIngreso=dia+"/"+mes+"/"+año;
                }
     });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            
             public void handle(ActionEvent event) {
                 
                       
                if(verificaInfo() == true)
           JOptionPane.showMessageDialog(null, "Porfavor ingrese toda la informacion necesaria.");
                else{   
                 titulo = texfieldTituloPeriodico.getText();
                 autor= textfieldAutor.getText();
                 codigoIssn=textfieldCodigoIssn.getText();
                
                Edicion = textareaEdicion.getText();
                 fechaPeriodico=fecha.getText();
                 Estado ="Disponible";
                Periodicos periodico=new Periodicos(titulo, fechaIngreso, autor, codigoIssn, Edicion, fechaPeriodico,Estado);
                periodico.Agregar(periodico);
                JOptionPane.showMessageDialog(null,"Periodico agregado con exito :)");
                 Limpiar();
                
            }
             }        
              });
           
            
             return gpVentanaLibros;

    
}
    public void Limpiar(){
      texfieldTituloPeriodico.setText("");
      textfieldAutor.setText("");
      textfieldCodigoIssn.setText("");
      textareaEdicion.setText("");
      fecha.setText("");
            }
    private boolean verificaInfo(){
         if(texfieldTituloPeriodico.getText().isEmpty())
             return true;
         else if(textfieldAutor.getText().isEmpty())
             return true;
         else if(textfieldCodigoIssn.getText().isEmpty())
             return true;
          else if(textareaEdicion.getText().isEmpty())
             return true;
           else if(fecha.getText().isEmpty())
             return true;
         else
             return false;
     }
       public BorderPane ventanaBorrarPeriodico(){
   
     BorderPane BorrarVentana = new BorderPane();
     GridPane ventanaCentroBorrar = new GridPane();
     HBox OrdenBotones = new HBox();
     Label Ordenartop = new Label("\n\n\n\n\n\n");
     Label Espacio = new Label("                ");

     Label etiquetaLibro = new Label("Titulo del Periodico:");
    texfieldTituloPeriodico = new TextField();
    
    
     Button btnBorrar = new Button("Borrar");
     Button btnIngresar= new Button("Ingresar");
     Button btnCancelar = new Button("Cancelar");
     
     
      btnBorrar.setDisable(true);
        btnCancelar.setDisable(true);
        
        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {

            tituloAux = texfieldTituloPeriodico.getText();
            if (tituloAux.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun Periodico");
            } 
            else {
                tituloAux = texfieldTituloPeriodico.getText();
            
            if (utilGestionar.buscar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))== true){
                btnBorrar.setDisable(false);
                btnCancelar.setDisable(false);
                btnIngresar.setDisable(true);

            } else {
                JOptionPane.showMessageDialog(null, "Periodico no se encuentra en registro");
            }
            }

        });//fin btnIngresar
        
        
        //Accion boton borrar
        btnBorrar.setOnAction((event) -> {
            tituloAux = texfieldTituloPeriodico.getText();

            btnBorrar.setDisable(true);
            texfieldTituloPeriodico.setText("");
            btnIngresar.setDisable(false);
            btnCancelar.setDisable(true);
            JOptionPane.showMessageDialog(null, "Periodico eliminado con exito");
            utilGestionar.eliminar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo),nombreArchivo),nombreArchivo);

        });//fin borrar
        btnCancelar.setOnAction((event) -> {
            texfieldTituloPeriodico.setText("");
            btnBorrar.setDisable(true);
            btnCancelar.setDisable(true);
            btnIngresar.setDisable(false);

        });//fin botonCancelar
        
     OrdenBotones.getChildren().addAll(btnIngresar,btnBorrar,btnCancelar);
     
     

   
     ventanaCentroBorrar.add(etiquetaLibro, 0, 0);
     ventanaCentroBorrar.add(texfieldTituloPeriodico, 1, 0);
     ventanaCentroBorrar.add(OrdenBotones, 1, 1);
    
            
    BorrarVentana.setRight(Espacio);
    BorrarVentana.setTop(Ordenartop);
    BorrarVentana.setCenter(ventanaCentroBorrar);
    ventanaCentroBorrar.setAlignment(Pos.CENTER);

     
     
        return BorrarVentana;
     
}
       
       
}

