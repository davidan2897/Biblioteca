/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 *
 * @author Michelle
 */
public class ModificarUsuario {
        public String nombreUni;
    public String nombreComple;
    static String identificacio;
    static String tipoIdentifica;
    static String tipoUsuario;
    public String contrase;

    String[] datosArchivo;

    TextField nombreUnic;
    TextField nombreComplet;
    TextField Tipoidentificacion, identificacionModificar, obra, mostrarIdentificacion, usuarioModificar;
    TextField identi;
    TextField contraseñ;

    TextField tipoUsuari;
    Button btnModificar, actualizarUsuario, verifica;
    Label mensajes, identificacion, mostarIdentificacion, nombre, mostrarNombre, contraseña, nombreUnico, TipoUsuario, Obra, usuarioActualiar;

    public GridPane interModificar() {

        GridPane modificarUsuario = new GridPane();
        modificarUsuario.setHgap(10);
        modificarUsuario.setVgap(10);
        modificarUsuario.setPadding(new Insets(20));

        //Crea labels y textfields
        Label titulo = new Label("Modificar Usuario");
        titulo.setFont(Font.font(17));
        usuarioModificar = new TextField();
        Label usuarioModificar = new Label("Introduzca el nombre de usuario");
        usuarioModificar.setFont(Font.font(17));

        btnModificar = new Button("Modificar");
        modificarUsuario.add(usuarioModificar, 2, 6);
        modificarUsuario.add(this.usuarioModificar, 2, 5);
        verifica = new Button("Verificar");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));

        modificarUsuario.add(verifica, 2, 7);

        CreayLeeArchivos cyla = new CreayLeeArchivos();

        //Pregunta si el usuario existe y muestra los componentes
        verifica.setOnAction(e -> {
            String nombreP = this.usuarioModificar.getText();

            if (cyla.existeUsuario(nombreP, "Usuarios.txt") == true) {
                usuarioModificar.setVisible(false);
                verifica.setVisible(false);
                this.usuarioModificar.setVisible(false);

//              
                datosArchivo = cyla.getDatosEspecificos("Usuarios.txt", nombreP);

                Label nombreUnico = new Label("Nombre unico");
                modificarUsuario.add(nombreUnico, 0, 0);
                nombreUnic = new TextField();
                modificarUsuario.add(nombreUnic, 1, 0);
                Label nombreCompleto = new Label("Nombre completo");
                modificarUsuario.add(nombreCompleto, 0, 1);
                nombreComplet = new TextField();
                modificarUsuario.add(nombreComplet, 1, 1);
                Label TipoIdentificacion = new Label("Tipo de Identificación");
                modificarUsuario.add(TipoIdentificacion, 0, 2);
                Tipoidentificacion = new TextField();
                modificarUsuario.add(Tipoidentificacion, 1, 2);
                Label identificacion = new Label("Identificación");
                modificarUsuario.add(identificacion, 0, 3);
                identi = new TextField();
                modificarUsuario.add(identi, 1, 3);
                Label contraseña = new Label("Contraseña");
                modificarUsuario.add(contraseña, 0, 4);
                contraseñ = new TextField();
                modificarUsuario.add(contraseñ, 1, 4);
                Label tipoUsuar = new Label("Tipo de Usuario");
                modificarUsuario.add(tipoUsuar, 0, 5);
                TextField tipoUsuari = new TextField();
                modificarUsuario.add(tipoUsuari, 1, 5);
                modificarUsuario.add(btnModificar, 0, 7);

                btnModificar.setOnAction((event) -> {

                    cyla.actualizarUsuario(nombreUnic.getText(), nombreComplet.getText(), Tipoidentificacion.getText(),
                            identi.getText(), contraseñ.getText(), tipoUsuari.getText());
                    mensajes.setVisible(true);
                    mensajes.setText("El usuario ha sido actualizado");

                });

                modificarUsuario.add(mensajes, 2, 0);
               
            } else {

                mensajes.setText("El usuario no existe");
                modificarUsuario.setVisible(false);

            }
        });

        return modificarUsuario;
    }//Fin modificarUsuarios

    
    public Button getButtonModificarUsuario() {
        //Crea boton
        actualizarUsuario = new Button("Modificar Usuario");
        actualizarUsuario.setFont(Font.font(17));
        actualizarUsuario.setVisible(false);

        //Actualiza los datos del autor
        actualizarUsuario.setOnAction(e -> {
            CreayLeeArchivos cyla = new CreayLeeArchivos();
            cyla.actualizarUsuario(nombreUnic.getText(), nombreComplet.getText(), Tipoidentificacion.getText(),
                    identi.getText(), contraseñ.getText(), tipoUsuari.getText());
            mensajes.setVisible(true);
            mensajes.setText("El usuario ha sido actualizado con exito");

            identificacionModificar.setText("");
            actualizarUsuario.setVisible(false);
        });
        return actualizarUsuario;
    }//Fin getButtonActualizar
    
}
