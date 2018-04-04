/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import domain.Periodicos;
import domain.Tesis;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    TextField texfieldTituloTesis ;
    TextField textfieldAutor;
    TextArea textareaResumen;
     TextArea textareaAbstract;
    Button btnAgregar;
    DatePicker datepickerFecha;
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
                 
                Tesis tesis=new Tesis(titulo, fechaIngreso, autor, Resumen, abstrac);
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
}
