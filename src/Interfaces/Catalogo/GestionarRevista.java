/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import domain.Periodicos;
import domain.Revistas;
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
public class GestionarRevista {
    public String titulo;
    
    public String autor;
     static String codigoIssn;
      
    public String Edicion;
    public String fechaIngreso;
     public String fechaRevista;
    TextField texfieldTituloRevista ;
    TextField textfieldAutor;
    TextField textfieldCodigoIssn;
    TextArea textareaEdicion;
    
    Button btnAgregar;
    DatePicker datepickerFecha;
    public GridPane AgregarRevista(){
    GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
         datepickerFecha = new DatePicker();
        Label labelTituloPeriodico = new Label("Titulo");
        gpVentanaLibros.add(labelTituloPeriodico, 0, 0);
        texfieldTituloRevista = new TextField();
        gpVentanaLibros.add(texfieldTituloRevista, 1, 0);
        Label labelAutor= new Label("Nombre del autor");
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
        
         Label labelFechaingreso = new Label("Fecha de ingreso");
        gpVentanaLibros.add(labelFechaingreso, 0, 4);
         gpVentanaLibros.add(datepickerFecha,1,4);
//        Msj = new Label("");
           gpVentanaLibros.add(btnAgregar, 0, 5);
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
                 titulo = texfieldTituloRevista.getText();
                 autor= textfieldAutor.getText();
                 codigoIssn=textfieldCodigoIssn.getText();
                
                Edicion = textareaEdicion.getText();
                
                Revistas revista=new Revistas(titulo, fechaIngreso, autor, codigoIssn, Edicion);
                revista.Agregar(revista);
                JOptionPane.showMessageDialog(null,"Revista agregada con exito :)");
                 Limpiar();
                
            }
             }        
              });
           
            
             return gpVentanaLibros;

    
}
    public void Limpiar(){
      texfieldTituloRevista.setText("");
      textfieldAutor.setText("");
      textfieldCodigoIssn.setText("");
       textareaEdicion.setText("");
            }
    private boolean verificaInfo(){
         if(texfieldTituloRevista.getText().isEmpty())
             return true;
         else if(textfieldAutor.getText().isEmpty())
             return true;
         else if(textfieldCodigoIssn.getText().isEmpty())
             return true;
          else if(textareaEdicion.getText().isEmpty())
             return true;
         else
             return false;
     } 
}
