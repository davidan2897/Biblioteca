/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class BuscarObra {

    ComboBox<String> comboTipoObra;
    String tituloArchivo = "", fechaIngreso = "", autorArchivo = "";
    String tituloAux, nombreArchivo;
    UtilidadesGestionar utilGestionar = new UtilidadesGestionar();

    TextArea textAInformacion;

    public BorderPane buscarObra() {
        //instancias de Layout

        BorderPane BuscarVentana = new BorderPane();
        GridPane ventanaCentroBuscar = new GridPane();
        VBox OrdenBotones = new VBox();
        Label Ordenartop = new Label("\n\n\n\n");
        Label Espacio = new Label("        ");
        Label acomodar = new Label("      ");
        comboTipoObra = new ComboBox<>();
        comboTipoObra.getItems().addAll("Libros", "Revistas", "Tesis", "Memorias", "Periodicos");
        Label etiquetatipoObra = new Label("Tipo Obra:");
        Label etiquetaTitulo = new Label("Titulo de la obra:");
        Label etiquetaNombreAutor = new Label("Nombre de Autor :");
        TextField texfieldTituloObra = new TextField();
        TextField texfNombreAutor = new TextField();
        ToggleGroup group_radioButton = new ToggleGroup();
        RadioButton radioBTitulo = new RadioButton("Titulo");
        RadioButton radioBautor = new RadioButton(" Autor  ");
        Label etiquetaBuscarPor = new Label("Buscar por:");
        HBox HboxRadioBotones = new HBox();
        Button btnIngresar = new Button("Ingresar");
        Button btnCancelar = new Button("Cancelar");
        radioBautor.setToggleGroup(group_radioButton);
        radioBTitulo.setToggleGroup(group_radioButton);
        HboxRadioBotones.getChildren().addAll(radioBautor, radioBTitulo);
        textAInformacion = new TextArea();

        textAInformacion.setEditable(false);
        Button btnNuevabusqueda = new Button("Nueva Busqueda");

        //Acciones de Layouts
        btnIngresar.setDisable(true);
        texfNombreAutor.setDisable(true);
        texfieldTituloObra.setDisable(true);
        btnNuevabusqueda.setDisable(true);
        textAInformacion.setDisable(true);

        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {

            if (comboTipoObra.getValue().toString().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "No se ha seleccionado un tipo de obra");
            } else {
                nombreArchivo = comboTipoObra.getValue().toString();
                nombreArchivo += ".txt";
                //Accion RadioBTitulo
                if (radioBTitulo.isSelected()) {
                    tituloAux = texfieldTituloObra.getText();
                    
                    if (tituloAux.isEmpty() == true) {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna Obra");
                    } else {
                        tituloAux = texfieldTituloObra.getText();
                        if (buscarObraTitulo(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))==true) {
                            JOptionPane.showMessageDialog(null, "Encontrado");
                            textAInformacion.setDisable(false);
                              btnNuevabusqueda.setDisable(false);

                           
                            textAInformacion.setText("Titulo: " + tituloArchivo + "\nAutor: " + autorArchivo + "\nFecha de Ingreso: " + fechaIngreso);
                             btnIngresar.setDisable(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encuentra en registro");
                        }
                    }

                }//fin radioBTitulo

                if (radioBautor.isSelected()) {
                    tituloAux = texfNombreAutor.getText();
                    
                    if (tituloAux.isEmpty() == true) {
                        JOptionPane.showMessageDialog(null, "No se ha ingresado ninguna Autor");
                    } else {
                        tituloAux = texfNombreAutor.getText();
                         if (buscarObraAutor(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))==true) {
                            JOptionPane.showMessageDialog(null, "Encontrado");
                            btnNuevabusqueda.setDisable(false);
                           textAInformacion.setDisable(false);
                            textAInformacion.setText("Titulo: " + tituloArchivo + "\nAutor: " + autorArchivo + "\nFecha de Ingreso: " + fechaIngreso);
                            btnIngresar.setDisable(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encuentra en registro");
                        }
                    }
                }//fin radioBautor

                 comboTipoObra.setValue("");
                btnCancelar.setDisable(true);
                texfNombreAutor.setText("");
                texfieldTituloObra.setText("");
            }
        });//fin btnIngresar

        //Accion Radio Botones
        //Accion radioBTitulo
        radioBTitulo.setOnAction((ActionEvent event) -> {
            texfNombreAutor.setDisable(true);
            texfieldTituloObra.setDisable(false);
            btnIngresar.setDisable(false);
        });
        //Accion radioBautor
        radioBautor.setOnAction((ActionEvent event) -> {
            texfieldTituloObra.setDisable(true);
            texfNombreAutor.setDisable(false);
            btnIngresar.setDisable(false);
        });
        //Accion btnCancelar
        btnCancelar.setOnAction((event) -> {

            comboTipoObra.setValue("");
            texfieldTituloObra.setText("");
            texfNombreAutor.setText("");
            btnIngresar.setDisable(false);
            

        });//fin botonCancelar
        btnNuevabusqueda.setOnAction((event) -> {
            comboTipoObra.setValue("");
            texfieldTituloObra.setText("");
            texfNombreAutor.setText("");
            btnIngresar.setDisable(false);
            textAInformacion.setText("");
            btnNuevabusqueda.setDisable(true);
            textAInformacion.setDisable(true);

        });

        OrdenBotones.getChildren().addAll(btnIngresar, btnCancelar);

        ventanaCentroBuscar.add(etiquetatipoObra, 1, 0);
        ventanaCentroBuscar.add(comboTipoObra, 2, 0);
        ventanaCentroBuscar.add(etiquetaBuscarPor, 1, 1);
        ventanaCentroBuscar.add(HboxRadioBotones, 2, 1);
        ventanaCentroBuscar.add(etiquetaNombreAutor, 1, 2);
        ventanaCentroBuscar.add(texfNombreAutor, 2, 2);
        ventanaCentroBuscar.add(etiquetaTitulo, 1, 3);
        ventanaCentroBuscar.add(texfieldTituloObra, 2, 3);
        ventanaCentroBuscar.add(OrdenBotones, 2, 4);
        ventanaCentroBuscar.add(textAInformacion, 4, 2);
        textAInformacion.setMaxSize(190, 70);
        ventanaCentroBuscar.add(Espacio, 3, 2);
        ventanaCentroBuscar.add(btnNuevabusqueda, 4, 3);

        BuscarVentana.setLeft(acomodar);
        BuscarVentana.setTop(Ordenartop);
        BuscarVentana.setCenter(ventanaCentroBuscar);
        ventanaCentroBuscar.setAlignment(Pos.CENTER);

        return BuscarVentana;

    }

    public boolean buscarObraTitulo(String titulo, String a[]) {
        String aux = "";

        boolean encontrado = false;
        for (int i = 0; i < a.length; i++) {
            aux = a[i];

            StringTokenizer st = new StringTokenizer(aux, ";");

            tituloArchivo = st.nextToken();
            fechaIngreso = st.nextToken();
            autorArchivo = st.nextToken();
            if (titulo.equals(tituloArchivo)) {
                encontrado = true;
               
                break;

            }//fin if

        }//fin for i

        return encontrado;
    }//fin buscarObraTitulo
    
     public boolean buscarObraAutor(String autor, String a[]) {
        String aux = "";

        boolean encontrado = false;
        for (int i = 0; i < a.length; i++) {
            aux = a[i];

            StringTokenizer st = new StringTokenizer(aux, ";");

            tituloArchivo = st.nextToken();
            fechaIngreso = st.nextToken();
            autorArchivo = st.nextToken();

            if (autor.equals(autorArchivo)) {
                encontrado = true;
                
                break;

            }//fin if

        }//fin for i

        return encontrado;
    }//fin buscarObraAutor
    
}
