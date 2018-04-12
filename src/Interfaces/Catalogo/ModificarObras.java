/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import java.time.LocalDate;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Michelle
 */
public class ModificarObras {
    
    DatePicker datepickerFecha;
    String[] datosArchivo;

    TextField Titulo;
    TextField Autor;
    TextField resumen, Fecha, tituloModificar, obra, MemoriaModificar, libroModificar, codigoISSN, revistaModificar, periodicoModificar, tesisModificar;
    TextField Tema, Abstract, edicion;
    TextField Subtema, conferecinaPresentada;

    Button btnModificar, actualizarLibro, verifica, actualizarMemoria, actualizarTesis, actualizarRevistas, actualizarPeriodico;
    Label mensajes, Obra;

    public GridPane interModificarLibros() {

        GridPane modificarLibro = new GridPane();
        modificarLibro.setHgap(10);
        modificarLibro.setVgap(10);
        modificarLibro.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Libro");
        titulo.setFont(Font.font(17));
        
       
        
        libroModificar = new TextField();
        Label libroModificar = new Label("Introduzca el titulo del libro");
        libroModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarLibro.add(libroModificar, 2, 6);
        modificarLibro.add(this.libroModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarLibro.add(verifica, 2, 7);

        ArchivosObras ao = new ArchivosObras();

        //Pregunta si el libro existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.libroModificar.getText();

            if (ao.existeObra(nombreP, "Libros.txt") == true) {
                libroModificar.setVisible(false);
                verifica.setVisible(false);
                this.libroModificar.setVisible(false);

                datosArchivo = ao.getDatosEspecificos("Libros.txt", nombreP);

                Label Titulo = new Label("Titulo Libro");
                modificarLibro.add(Titulo, 0, 0);
                this.Titulo = new TextField();
                modificarLibro.add(this.Titulo, 1, 0);

                Label fechaIngreso = new Label("Fecha de ingreso:");
                fechaIngreso = new Label();
                datepickerFecha = new DatePicker();
                datepickerFecha.setValue(LocalDate.now());

                Label Autor = new Label("Autor");
                modificarLibro.add(Autor, 0, 1);
                this.Autor = new TextField();
                modificarLibro.add(this.Autor, 1, 1);
                Label codigoISBN = new Label("Codigo ISBN");
                modificarLibro.add(codigoISBN, 0, 2);
                this.resumen = new TextField();
                modificarLibro.add(this.resumen, 1, 2);
                Label tema = new Label("Tema");
                modificarLibro.add(tema, 0, 3);
                Tema = new TextField();
                modificarLibro.add(Tema, 1, 3);
                Label subtema = new Label("Subtema");
                modificarLibro.add(subtema, 0, 4);
                Subtema = new TextField();
                modificarLibro.add(Subtema, 1, 4);
                modificarLibro.add(btnModificar, 0, 5);

                btnModificar.setOnAction((event) -> {

                    ao.actualizarLibro(this.Titulo.getText(), "" + datepickerFecha, "" + this.Autor.getText(), this.resumen.getText(),
                            this.Tema.getText(), this.Subtema.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("El Libro ha sido actualizado");

                });

                modificarLibro.add(mensajes, 2, 0);
//                modificarUsuario.add(getButtonModificarUsuario(), 0, 8);

            } else {
//                ocultaComponentes(true);
                mensajes.setText("El libro no existe");
                modificarLibro.setVisible(false);

            }
        });

        return modificarLibro;
    }//Fin modificar

    public Button getButtonModificarLibro() {
        //Crea boton
        actualizarLibro = new Button("Modificar Libro");
        actualizarLibro.setFont(Font.font(17));
        actualizarLibro.setVisible(false);

        //Actualiza los datos del libro
        actualizarLibro.setOnAction(e -> {
            ArchivosObras ao = new ArchivosObras();
            ao.actualizarLibro(Titulo.getText(), "" + datepickerFecha.getValue(), "" + Autor.getText(), resumen.getText(),
                    Tema.getText(), Subtema.getText());
            mensajes.setVisible(true);
            mensajes.setText("El libro ha sido actualizado con exito");

            tituloModificar.setText("");
            actualizarLibro.setVisible(false);
        });
        return actualizarLibro;
    }//Fin getButtonActualizar

    public GridPane interModificarMemorias() {

        GridPane modificarMemoria = new GridPane();
        modificarMemoria.setHgap(10);
        modificarMemoria.setVgap(10);
        modificarMemoria.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Memoria");
        titulo.setFont(Font.font(17));
        MemoriaModificar = new TextField();
        Label memoriaModificar = new Label("Introduzca el titulo de la memoria");
        memoriaModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarMemoria.add(memoriaModificar, 2, 6);
        modificarMemoria.add(this.MemoriaModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarMemoria.add(verifica, 2, 7);

        ArchivosObras ao = new ArchivosObras();

        //Pregunta si el libro existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.MemoriaModificar.getText();

            if (ao.existeObra(nombreP, "Memorias.txt") == true) {
                memoriaModificar.setVisible(false);
                verifica.setVisible(false);
                this.MemoriaModificar.setVisible(false);

                datosArchivo = ao.getDatosEspecificos("Memorias.txt", nombreP);

                Label Titulo = new Label("Titulo Memoria");
                modificarMemoria.add(Titulo, 0, 0);
                this.Titulo = new TextField();
                modificarMemoria.add(this.Titulo, 1, 0);

                Label fechaIngreso = new Label("Fecha de ingreso:");
                fechaIngreso = new Label();
                datepickerFecha = new DatePicker();
                datepickerFecha.setValue(LocalDate.now());

                Label Autor = new Label("Autor");
                modificarMemoria.add(Autor, 0, 1);
                this.Autor = new TextField();
                modificarMemoria.add(this.Autor, 1, 1);
                Label resumen = new Label("Resumen");
                modificarMemoria.add(resumen, 0, 2);
                this.resumen = new TextField();
                modificarMemoria.add(this.resumen, 1, 2);

                Label Abstract = new Label("Abstract");
                modificarMemoria.add(Abstract, 0, 3);
                this.Abstract = new TextField();
                modificarMemoria.add(this.Abstract, 1, 3);

                Label conferecinaPresentada = new Label("Conferencia Presentada");
                modificarMemoria.add(conferecinaPresentada, 0, 4);
                this.conferecinaPresentada = new TextField();
                modificarMemoria.add(this.conferecinaPresentada, 1, 4);

                modificarMemoria.add(btnModificar, 0, 5);

                btnModificar.setOnAction((event) -> {

                    ao.actualizarMemoria(this.Titulo.getText(), "" + datepickerFecha, "" + this.Autor.getText(), this.resumen.getText(),
                            this.Abstract.getText(), this.conferecinaPresentada.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("La memoria ha sido actualizado");

                });

                modificarMemoria.add(mensajes, 2, 0);
//                modificarUsuario.add(getButtonModificarUsuario(), 0, 8);

            } else {
//                ocultaComponentes(true);
                mensajes.setText("La memoria no existe");
                modificarMemoria.setVisible(false);

            }
        });

        return modificarMemoria;
    }//Fin modificar

    public Button getButtonModificarMemoria() {
        //Crea boton
        actualizarMemoria = new Button("Modificar Memoria");
        actualizarMemoria.setFont(Font.font(17));
        actualizarMemoria.setVisible(false);

        //Actualiza los datos del libro
        actualizarMemoria.setOnAction(e -> {
            ArchivosObras ao = new ArchivosObras();
            ao.actualizarLibro(Titulo.getText(), "" + datepickerFecha.getValue(), "" + Autor.getText(), resumen.getText(),
                    Abstract.getText(), conferecinaPresentada.getText());
            mensajes.setVisible(true);
            mensajes.setText("La memoria ha sido actualizado con exito");

            tituloModificar.setText("");
            actualizarMemoria.setVisible(false);
        });
        return actualizarMemoria;
    }//Fin getButtonActualizar

    public GridPane interModificarRevistas() {

        GridPane modificarRevista = new GridPane();
        modificarRevista.setHgap(10);
        modificarRevista.setVgap(10);
        modificarRevista.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Revista");
        titulo.setFont(Font.font(17));
        revistaModificar = new TextField();
        Label revistasModificar = new Label("Introduzca el titulo de la revista");
        revistasModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarRevista.add(revistasModificar, 2, 6);
        modificarRevista.add(this.revistaModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarRevista.add(verifica, 2, 7);

        ArchivosObras ao = new ArchivosObras();

        //Pregunta si el libro existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.revistaModificar.getText();

            if (ao.existeObra(nombreP, "Revistas.txt") == true) {
                revistaModificar.setVisible(false);
                verifica.setVisible(false);
                this.revistaModificar.setVisible(false);

                datosArchivo = ao.getDatosEspecificos("Revistas.txt", nombreP);

                Label Titulo = new Label("Titulo Revista");
                modificarRevista.add(Titulo, 0, 0);
                this.Titulo = new TextField();
                modificarRevista.add(this.Titulo, 1, 0);

                Label fechaIngreso = new Label("Fecha de ingreso:");
                fechaIngreso = new Label();
                datepickerFecha = new DatePicker();
                datepickerFecha.setValue(LocalDate.now());

                Label Autor = new Label("Autor");
                modificarRevista.add(Autor, 0, 1);
                this.Autor = new TextField();
                modificarRevista.add(this.Autor, 1, 1);

                Label codigoISSN = new Label("Codigo ISSN");
                modificarRevista.add(codigoISSN, 0, 2);
                this.codigoISSN = new TextField();
                modificarRevista.add(this.codigoISSN, 1, 2);

                Label edicion = new Label("Edicion");
                modificarRevista.add(edicion, 0, 3);
                this.edicion = new TextField();
                modificarRevista.add(this.edicion, 1, 3);
                modificarRevista.add(btnModificar, 0, 5);

                btnModificar.setOnAction((event) -> {

                    ao.actualizarRevista(this.Titulo.getText(), "" + datepickerFecha, "" + this.Autor.getText(), this.codigoISSN.getText(),
                            this.edicion.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("La revista ha sido actualizada");

                });

                modificarRevista.add(mensajes, 2, 0);
//                modificarUsuario.add(getButtonModificarUsuario(), 0, 8);

            } else {
//                ocultaComponentes(true);
                mensajes.setText("La revista no existe");
                modificarRevista.setVisible(false);

            }
        });

        return modificarRevista;
    }//Fin modificar

    public Button getButtonModificarRevista() {
        //Crea boton
        actualizarRevistas = new Button("Modificar Revistas");
        actualizarRevistas.setFont(Font.font(17));
        actualizarRevistas.setVisible(false);

        //Actualiza los datos  
        actualizarRevistas.setOnAction(e -> {
            ArchivosObras ao = new ArchivosObras();
            ao.actualizarRevista(Titulo.getText(), "" + datepickerFecha.getValue(), "" + Autor.getText(), codigoISSN.getText(),
                    edicion.getText());
            mensajes.setVisible(true);
            mensajes.setText("La revista ha sido actualizado con exito");

            tituloModificar.setText("");
            actualizarLibro.setVisible(false);
        });
        return actualizarLibro;
    }//Fin getButtonActualizar
    
     public GridPane interModificarPeriodicos() {

        GridPane modificarPeriodico = new GridPane();
        modificarPeriodico.setHgap(10);
        modificarPeriodico.setVgap(10);
        modificarPeriodico.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Periodico");
        titulo.setFont(Font.font(17));
        periodicoModificar = new TextField();
        Label periodicosModificar = new Label("Introduzca el titulo del periodico");
        periodicosModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarPeriodico.add(periodicosModificar, 2, 6);
        modificarPeriodico.add(this.periodicoModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarPeriodico.add(verifica, 2, 7);

        ArchivosObras ao = new ArchivosObras();

        //Pregunta si el libro existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.periodicoModificar.getText();

            if (ao.existeObra(nombreP, "Periodicos.txt") == true) {
                periodicoModificar.setVisible(false);
                verifica.setVisible(false);
                this.periodicoModificar.setVisible(false);

                datosArchivo = ao.getDatosEspecificos("Periodicos.txt", nombreP);

                Label Titulo = new Label("Titulo Libro");
                modificarPeriodico.add(Titulo, 0, 0);
                this.Titulo = new TextField();
                modificarPeriodico.add(this.Titulo, 1, 0);

                Label fechaIngreso = new Label("Fecha de ingreso:");
                fechaIngreso = new Label();
                datepickerFecha = new DatePicker();
                datepickerFecha.setValue(LocalDate.now());

                Label Autor = new Label("Autor");
                modificarPeriodico.add(Autor, 0, 1);
                this.Autor = new TextField();
                modificarPeriodico.add(this.Autor, 1, 1);
                
                Label codigoISSN = new Label("Codigo ISSN");
                modificarPeriodico.add(codigoISSN, 0, 2);
                
                this.edicion = new TextField();
                modificarPeriodico.add(this.edicion, 1, 2);
                Label edicion = new Label("Edicion");
                modificarPeriodico.add(edicion, 0, 3);
                
                Label fecha = new Label("Fecha");
                modificarPeriodico.add(fecha, 0, 4);
                Fecha = new TextField();
                modificarPeriodico.add(Fecha, 1, 4);
                modificarPeriodico.add(btnModificar, 0, 5);

                btnModificar.setOnAction((event) -> {

                    ao.actualizarPeriodicos(this.Titulo.getText(), "" + datepickerFecha, "" + this.Autor.getText(), this.codigoISSN.getText(),
                            this.edicion.getText(), this.Fecha.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("El periodico ha sido actualizado");

                });

                modificarPeriodico.add(mensajes, 2, 0);
//                modificarUsuario.add(getButtonModificarUsuario(), 0, 8);

            } else {
//                ocultaComponentes(true);
                mensajes.setText("El periodico no existe");
                modificarPeriodico.setVisible(false);

            }
        });

        return modificarPeriodico;
    }//Fin modificar

    public Button getButtonModificarPeriodico() {
        //Crea boton
        actualizarPeriodico = new Button("Modificar Periodico");
        actualizarPeriodico.setFont(Font.font(17));
        actualizarPeriodico.setVisible(false);

        //Actualiza los datos del libro
        actualizarPeriodico.setOnAction(e -> {
            ArchivosObras ao = new ArchivosObras();
            ao.actualizarPeriodicos(Titulo.getText(), "" + datepickerFecha.getValue(), "" + Autor.getText(), codigoISSN.getText(),
                    edicion.getText(),Fecha.getText());
            mensajes.setVisible(true);
            mensajes.setText("El periodico ha sido actualizado con exito");

            tituloModificar.setText("");
            actualizarPeriodico.setVisible(false);
        });
        return actualizarPeriodico;
    }//Fin getButtonActualizar

    public GridPane interModificarTesis() {

        GridPane modificarTesis = new GridPane();
        modificarTesis.setHgap(10);
        modificarTesis.setVgap(10);
        modificarTesis.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Tesis");
        titulo.setFont(Font.font(17));
        tesisModificar = new TextField();
        Label tesiModificar = new Label("Introduzca el titulo del libro");
        tesiModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarTesis.add(tesiModificar, 2, 6);
        modificarTesis.add(this.tesisModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarTesis.add(verifica, 2, 7);

        ArchivosObras ao = new ArchivosObras();

        //Pregunta si el libro existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.tesisModificar.getText();

            if (ao.existeObra(nombreP, "Tesis.txt") == true) {
                tesisModificar.setVisible(false);
                verifica.setVisible(false);
                this.tesisModificar.setVisible(false);

                datosArchivo = ao.getDatosEspecificos("Tesis.txt", nombreP);

                Label Titulo = new Label("Titulo Tesis");
                modificarTesis.add(Titulo, 0, 0);
                this.Titulo = new TextField();
                modificarTesis.add(this.Titulo, 1, 0);

                Label fechaIngreso = new Label("Fecha de ingreso:");
                fechaIngreso = new Label();
                datepickerFecha = new DatePicker();
                datepickerFecha.setValue(LocalDate.now());

                Label Autor = new Label("Autor");
                modificarTesis.add(Autor, 0, 1);
                this.Autor = new TextField();
                modificarTesis.add(this.Autor, 1, 1);
                
                this.resumen = new TextField();
                modificarTesis.add(this.resumen, 1, 2);
                
                Label Abstract = new Label("abstract");
                modificarTesis.add(Abstract, 0, 3);
               this.Abstract = new TextField();
                modificarTesis.add(this.Abstract, 1, 3);
           
                modificarTesis.add(btnModificar, 0, 5);

                btnModificar.setOnAction((event) -> {

                    ao.actualizarTesis(this.Titulo.getText(), "" + datepickerFecha, "" + this.Autor.getText(), this.resumen.getText(),
                            this.Abstract.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("La tesis ha sido actualizado");

                });

                modificarTesis.add(mensajes, 2, 0);
//                modificarUsuario.add(getButtonModificarUsuario(), 0, 8);

            } else {
//                ocultaComponentes(true);
                mensajes.setText("La tesis no existe");
                modificarTesis.setVisible(false);

            }
        });

        return modificarTesis;
    }//Fin modificar

    public Button getButtonModificarTesis() {
        //Crea boton
        actualizarTesis = new Button("Modificar Tesis");
        actualizarTesis.setFont(Font.font(17));
        actualizarTesis.setVisible(false);

        //Actualiza los datos del libro
        actualizarTesis.setOnAction(e -> {
            ArchivosObras ao = new ArchivosObras();
            ao.actualizarTesis(Titulo.getText(), "" + datepickerFecha.getValue(), "" + Autor.getText(), resumen.getText(),
                    Abstract.getText());
            mensajes.setVisible(true);
            mensajes.setText("La tesis ha sido actualizado con exito");

            tituloModificar.setText("");
            actualizarTesis.setVisible(false);
        });
        return actualizarTesis;
    }//Fin getButtonActualizar
    
}
