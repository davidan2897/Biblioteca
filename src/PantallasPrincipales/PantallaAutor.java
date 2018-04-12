/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PantallasPrincipales;

import Interfaces.Usuarios.ListasObrasAutorPrincipal;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *

 */
public class PantallaAutor {
    ListasObrasAutorPrincipal listaObrasAutor=new ListasObrasAutorPrincipal();
 public BorderPane interfazAutor() {

         BorderPane ventanaAutor = new BorderPane();
        GridPane ventanaCentro = new GridPane();
        VBox vboxControlador = new VBox();
        Label Ordenartop = new Label("\n");
        Label Ordenartopp = new Label("\n");
        Label Ordenartoppp = new Label("\n");
        Label Espacio = new Label("                ");
        Label etiquetaSeleccionartipoObra = new Label("Seleccione el tipo de obra:");
        ToggleGroup group_radioButton = new ToggleGroup();
        RadioButton radioBLibros = new RadioButton("Libros ");
        RadioButton radioBRevistas = new RadioButton("Revistas ");
        RadioButton radioBMemorias = new RadioButton("Memorias ");
        RadioButton radioBTesis = new RadioButton("Tesis ");
        RadioButton radioBPeriodicos = new RadioButton("Periodicos ");
        HBox hboxOrdenRadioBotones = new HBox();
        
        radioBLibros.setToggleGroup(group_radioButton);
        radioBMemorias.setToggleGroup(group_radioButton);
        radioBPeriodicos.setToggleGroup(group_radioButton);
        radioBRevistas.setToggleGroup(group_radioButton);
        radioBTesis.setToggleGroup(group_radioButton);
        
        //Accion Radio botones
        radioBLibros.setOnAction((ActionEvent event) -> {
            vboxControlador.getChildren().clear();
               vboxControlador.getChildren().addAll(listaObrasAutor.MostrarListalibros());
              
        
        });
        radioBMemorias.setOnAction((ActionEvent event) -> {
             vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(listaObrasAutor.MostrarListaMemorias());
             

        });
        radioBPeriodicos.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
              vboxControlador.getChildren().addAll(listaObrasAutor.MostrarListaPeriodicos());
        });
        radioBRevistas.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
              vboxControlador.getChildren().addAll(listaObrasAutor.MostrarListaRevistas());
      
        });
        radioBTesis.setOnAction((ActionEvent event) -> {
            vboxControlador.getChildren().clear();
             vboxControlador.getChildren().addAll(listaObrasAutor.MostrarListaTesis());
        
        });
        
        
        hboxOrdenRadioBotones.getChildren().addAll(radioBMemorias,radioBLibros,radioBPeriodicos,radioBRevistas,radioBTesis);
        
        ventanaCentro.add(Ordenartop, 0, 0);
        ventanaCentro.add(etiquetaSeleccionartipoObra, 0, 1);
        ventanaCentro.add(Ordenartoppp, 0, 2);
        ventanaCentro.add(hboxOrdenRadioBotones, 0, 3);
        ventanaCentro.add(Ordenartopp, 0, 4);
        ventanaCentro.add(vboxControlador,0,5);
        
        
         
        ventanaAutor.setTop(ventanaCentro);
       ventanaCentro.setAlignment(Pos.CENTER);
        return ventanaAutor;

 }
    
}
