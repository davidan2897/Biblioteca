/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import Constructores.Tesis;
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
public class GestionarTesis {

    public String titulo;
    public String autor;
    static String Resumen;
    public String fechaIngreso;
    static String abstrac;
    public String Estado;
    TextField texfieldTituloTesis;
    TextField textfieldAutor;
    TextArea textareaResumen;
    TextArea textareaAbstract;
    Button btnAgregar;
    DatePicker datepickerFecha;
    String tituloAux, nombreArchivo = "Tesis.txt";
    UtilidadesGestionar utilGestionar = new UtilidadesGestionar();

    public GridPane AgregarTesis(){
    GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
         datepickerFecha = new DatePicker();
        Label labelTituloTesis = new Label("Titulo");
        gpVentanaLibros.add(labelTituloTesis, 0, 0);
        texfieldTituloTesis = new TextField();
        gpVentanaLibros.add(texfieldTituloTesis, 1, 0);
        Label labelAutor= new Label("Nombre del autor");
        gpVentanaLibros.add(labelAutor, 0, 1);
         textfieldAutor= new TextField();
        gpVentanaLibros.add(textfieldAutor, 1, 1);
        Label resumen = new Label("Resumen");
        gpVentanaLibros.add(resumen, 0, 2);
         textareaResumen= new TextArea();
        gpVentanaLibros.add(textareaResumen, 1, 2);
         Label labelAbstract = new Label("Abstract");
        gpVentanaLibros.add(labelAbstract, 0, 4);
         textareaAbstract = new TextArea();
       gpVentanaLibros.add(textareaAbstract, 1, 4);
         Label labelFechaingreso = new Label("Fecha de ingreso");
        gpVentanaLibros.add(labelFechaingreso, 0, 3);
         gpVentanaLibros.add(datepickerFecha,1,3);
//        Msj = new Label("");
           gpVentanaLibros.add(btnAgregar, 0, 5);
         textareaResumen.setPrefWidth(100);
         textareaResumen.setPrefHeight(100);
         textareaAbstract.setPrefWidth(100);
         textareaAbstract.setPrefHeight(100);
        
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
                 titulo = texfieldTituloTesis.getText();
                 autor= textfieldAutor.getText();
                 Resumen=textareaResumen.getText();
                  abstrac=textareaAbstract.getText();
                 Estado ="Disponible";
                Tesis tesis=new Tesis(titulo, fechaIngreso, autor, Resumen, abstrac,Estado);
                tesis.Agregar(tesis);
                JOptionPane.showMessageDialog(null,"Tesis agregada con exito :)");
                 Limpiar();
                
            }
             }        
              });
           
            
             return gpVentanaLibros;

    
}
    public void Limpiar(){
      texfieldTituloTesis.setText("");
      textfieldAutor.setText("");
      textareaAbstract.setText("");
      textareaResumen.setText("");
            }
    private boolean verificaInfo(){
         if(texfieldTituloTesis.getText().isEmpty())
             return true;
         else if(textfieldAutor.getText().isEmpty())
             return true;
         else if(textareaAbstract.getText().isEmpty())
             return true;
           else if(textareaResumen.getText().isEmpty())
             return true;
         else
             return false;
     }
    
    public BorderPane ventanaBorrarTesis(){
   
     BorderPane BorrarVentana = new BorderPane();
     GridPane ventanaCentroBorrar = new GridPane();
     HBox OrdenBotones = new HBox();
     Label Ordenartop = new Label("\n\n\n\n\n\n");
     Label Espacio = new Label("                ");

     Label etiquetaLibro = new Label("Titulo de la Tesis:");
    texfieldTituloTesis= new TextField();
    
    
     Button btnBorrar = new Button("Borrar");
     Button btnIngresar= new Button("Ingresar");
     Button btnCancelar = new Button("Cancelar");
     
     
      btnBorrar.setDisable(true);
        btnCancelar.setDisable(true);
        
        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {

            tituloAux =  texfieldTituloTesis.getText();
            if (tituloAux.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna Tesis");
            } 
            else {
                tituloAux =  texfieldTituloTesis.getText();
            
            if (utilGestionar.buscar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))== true){
                btnBorrar.setDisable(false);
                btnCancelar.setDisable(false);
                btnIngresar.setDisable(true);

            } else {
                JOptionPane.showMessageDialog(null, "Tesis no se encuentra en registro");
            }
            }

        });//fin btnIngresar
        
        
        //Accion boton borrar
        btnBorrar.setOnAction((event) -> {
            tituloAux =  texfieldTituloTesis.getText();

            btnBorrar.setDisable(true);
            texfieldTituloTesis.setText("");
            btnIngresar.setDisable(false);
            btnCancelar.setDisable(true);
            JOptionPane.showMessageDialog(null, "Tesis eliminada con exito");
            utilGestionar.eliminar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo),nombreArchivo),nombreArchivo);

        });//fin borrar
        btnCancelar.setOnAction((event) -> {
             texfieldTituloTesis.setText("");
            btnBorrar.setDisable(true);
            btnCancelar.setDisable(true);
            btnIngresar.setDisable(false);

        });//fin botonCancelar
        
     OrdenBotones.getChildren().addAll(btnIngresar,btnBorrar,btnCancelar);
     
     

   
     ventanaCentroBorrar.add(etiquetaLibro, 0, 0);
     ventanaCentroBorrar.add( texfieldTituloTesis, 1, 0);
     ventanaCentroBorrar.add(OrdenBotones, 1, 1);
    
            
    BorrarVentana.setRight(Espacio);
    BorrarVentana.setTop(Ordenartop);
    BorrarVentana.setCenter(ventanaCentroBorrar);
    ventanaCentroBorrar.setAlignment(Pos.CENTER);

     
     
        return BorrarVentana;
     
}
}
