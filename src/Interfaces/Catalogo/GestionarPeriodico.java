/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import domain.Memorias;
import domain.Periodicos;
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
public class GestionarPeriodico {
        public String titulo;
    
    public String autor;
     static String codigoIssn;
      
    public String Edicion;
    public String fechaIngreso;
     public String fechaPeriodico;
    TextField texfieldTitulomemoria ;
    TextField textfieldAutor;
    TextField textfieldCodigoIssn;
    TextArea textareaEdicion;
    TextField fecha;
    Button btnAgregar;
    DatePicker datepickerFecha;
    public GridPane AgregarPeriodico(){
    GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
         datepickerFecha = new DatePicker();
        Label labelTituloPeriodico = new Label("Titulo");
        gpVentanaLibros.add(labelTituloPeriodico, 0, 0);
        texfieldTitulomemoria = new TextField();
        gpVentanaLibros.add(texfieldTitulomemoria, 1, 0);
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
                 titulo = texfieldTitulomemoria.getText();
                 autor= textfieldAutor.getText();
                 codigoIssn=textfieldCodigoIssn.getText();
                
                Edicion = textareaEdicion.getText();
                 fechaPeriodico=fecha.getText();
                Periodicos periodico=new Periodicos(titulo, fechaIngreso, autor, codigoIssn, Edicion, fechaPeriodico);
                periodico.Agregar(periodico);
                JOptionPane.showMessageDialog(null,"Periodico agregado con exito :)");
                 Limpiar();
                
            }
             }        
              });
           
            
             return gpVentanaLibros;

    
}
    public void Limpiar(){
      texfieldTitulomemoria.setText("");
      textfieldAutor.setText("");
      textfieldCodigoIssn.setText("");
      textareaEdicion.setText("");
      fecha.setText("");
            }
    private boolean verificaInfo(){
         if(texfieldTitulomemoria.getText().isEmpty())
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
}
