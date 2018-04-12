
package Interfaces.Catalogo;


import Constructores.Libros;
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
 * @author David
 */
public class GestionarLibros {

    public String titulo;
    static String tema;
    public String subtema;
    public String fechaIngreso;
    public String autor;
    public String codigoisbn;
    public String Estado;
    

    TextField texfieldTituloLibro;
    TextField textfieldAutor;
    TextField textfieldCodigo;
    TextArea textareaTema;
    TextArea textareaSubtema;
    Button btnAgregar;
    DatePicker datepickerFecha;
    String tituloAux, nombreArchivo = "Libros.txt";
    UtilidadesGestionar utilGestionar = new UtilidadesGestionar();

    public GridPane AgregarLibros() {
        GridPane gpVentanaLibros = new GridPane();
        btnAgregar = new Button("Agregar");
        datepickerFecha = new DatePicker();
        Label labelTituloLibro = new Label("Titulo");
        gpVentanaLibros.add(labelTituloLibro, 0, 0);
        texfieldTituloLibro = new TextField();
        gpVentanaLibros.add(texfieldTituloLibro, 1, 0);
        Label labelAutor = new Label("Autor");
        gpVentanaLibros.add(labelAutor, 0, 1);
        textfieldAutor = new TextField();
        gpVentanaLibros.add(textfieldAutor, 1, 1);
        Label codigoIsbn = new Label("Código ISBN");
        gpVentanaLibros.add(codigoIsbn, 0, 2);
        textfieldCodigo = new TextField();
        gpVentanaLibros.add(textfieldCodigo, 1, 2);
        Label labelTema = new Label("Tema");
        gpVentanaLibros.add(labelTema, 0, 3);
        textareaTema = new TextArea();
        gpVentanaLibros.add(textareaTema, 1, 3);
        Label labelSubtema = new Label("Subtema");
        gpVentanaLibros.add(labelSubtema, 0, 4);
        textareaSubtema = new TextArea();
        gpVentanaLibros.add(textareaSubtema, 1, 4);
        Label labelFechaingreso = new Label("Fecha de ingreso");
        gpVentanaLibros.add(labelFechaingreso, 0, 5);
        gpVentanaLibros.add(datepickerFecha, 1, 5);

        gpVentanaLibros.add(btnAgregar, 0, 6);
        textareaTema.setPrefWidth(100);
        textareaTema.setPrefHeight(100);
        textareaSubtema.setPrefWidth(100);
        textareaSubtema.setPrefHeight(100);

        datepickerFecha.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datepickerFecha.getValue();
                int dia = date.getDayOfMonth();
                int mes = date.getMonthValue();
                int año = date.getYear();
                fechaIngreso = dia + "/" + mes + "/" + año;
            }
        });
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {

                if (verificaInfo() == true) {
                    JOptionPane.showMessageDialog(null, "Porfavor ingrese toda la informacion necesaria.");
                } else {
                    titulo = texfieldTituloLibro.getText();
                    autor = textfieldAutor.getText();
                    codigoisbn = textfieldCodigo.getText();

                    tema = textareaTema.getText();
                    subtema = textareaSubtema.getText();
                    Estado ="Disponible";
                    Libros libros = new Libros(titulo, fechaIngreso, autor, codigoisbn, tema, subtema,Estado);
                    libros.Agregar(libros);
                    JOptionPane.showMessageDialog(null, "Libro agregado con exito :)");
                    Limpiar();

                }
            }
        });

        return gpVentanaLibros;

    }

    public void Limpiar() {
        texfieldTituloLibro.setText("");
        textfieldAutor.setText("");
        textfieldCodigo.setText("");
        textareaTema.setText("");
        textareaSubtema.setText("");
    }

    private boolean verificaInfo() {
        if (texfieldTituloLibro.getText().isEmpty()) {
            return true;
        } else if (textfieldAutor.getText().isEmpty()) {
            return true;
        } else if (textfieldCodigo.getText().isEmpty()) {
            return true;
        } else if (textareaTema.getText().isEmpty()) {
            return true;
        } else if (textareaTema.getText().isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public BorderPane ventanaBorrarLibro() {

        BorderPane BorrarVentana = new BorderPane();
        GridPane ventanaCentroBorrar = new GridPane();
        HBox OrdenBotones = new HBox();
        Label Ordenartop = new Label("\n\n\n\n\n\n");
        Label Espacio = new Label("                ");

        Label etiquetaLibro = new Label("Titulo del Libro:");
        texfieldTituloLibro = new TextField();

        Button btnBorrar = new Button("Borrar");
        Button btnIngresar = new Button("Ingresar");
        Button btnCancelar = new Button("Cancelar");

        btnBorrar.setDisable(true);
        btnCancelar.setDisable(true);

        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {

            tituloAux = texfieldTituloLibro.getText();
            if (tituloAux.isEmpty() == true) {
                JOptionPane.showMessageDialog(null, "No se ha ingresado ningun libro");
            } else {
                tituloAux = texfieldTituloLibro.getText();

                if (utilGestionar.buscar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo))== true){
                    btnBorrar.setDisable(false);
                    btnCancelar.setDisable(false);
                    btnIngresar.setDisable(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Libro no se encuentra en registro");
                }
            }

        });//fin btnIngresar

        //Accion boton borrar
        btnBorrar.setOnAction((event) -> {
            tituloAux = texfieldTituloLibro.getText();

            btnBorrar.setDisable(true);
            texfieldTituloLibro.setText("");
            btnIngresar.setDisable(false);
            btnCancelar.setDisable(true);
            JOptionPane.showMessageDialog(null, "Libro eliminado con exito");
             utilGestionar.eliminar(tituloAux, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo),nombreArchivo),nombreArchivo);

        });//fin borrar
        btnCancelar.setOnAction((event) -> {
            texfieldTituloLibro.setText("");
            btnBorrar.setDisable(true);
            btnCancelar.setDisable(true);
            btnIngresar.setDisable(false);

        });//fin botonCancelar

        OrdenBotones.getChildren().addAll(btnIngresar, btnBorrar, btnCancelar);

        ventanaCentroBorrar.add(etiquetaLibro, 0, 0);
        ventanaCentroBorrar.add(texfieldTituloLibro, 1, 0);
        ventanaCentroBorrar.add(OrdenBotones, 1, 1);

        BorrarVentana.setRight(Espacio);
        BorrarVentana.setTop(Ordenartop);
        BorrarVentana.setCenter(ventanaCentroBorrar);
        ventanaCentroBorrar.setAlignment(Pos.CENTER);

        return BorrarVentana;

    }//finVentanaCerrar

}
