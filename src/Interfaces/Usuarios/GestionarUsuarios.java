/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Usuarios;

import domain.Autores;
import domain.CreayLeeArchivos;
import domain.Usuario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GestionarUsuarios {
     public String nombreUni;
    public String nombreComple;
     static String identificacio;
      static String tipoIdentifica;
    public String contrase;
      static String tipoUsuario;
      String []datosArchivo;
    TextField nombreUnic ;
    TextField nombreComplet;
    TextField Tipoidentificacion,identificacionModificar, obra, mostrarIdentificacion;;
    TextField identi;
    TextField contraseñ;
    TextField tipoUsuari;
    Button btnAgregar, modificarUsuario, actualizarUsuario;
     Label mensajes, identificacion, mostarIdentificacion,nombre, mostrarNombre,contraseña,nombreUnico,TipoUsuario,Obra, usuarioActualiar;
    
    public GridPane AgregarAutor(){
    GridPane gpVentanaBibliotecario = new GridPane();
        btnAgregar = new Button("Agregar");
     
        Label nombreUnico = new Label("Nombre unico");
        gpVentanaBibliotecario.add(nombreUnico, 0, 0);
        nombreUnic = new TextField();
        gpVentanaBibliotecario.add(nombreUnic, 1, 0);
        Label nombreCompleto = new Label("Nombre completo");
        gpVentanaBibliotecario.add(nombreCompleto, 0, 1);
         nombreComplet = new TextField();
        gpVentanaBibliotecario.add(nombreComplet, 1, 1);
        Label TipoIdentificacion = new Label("Tipo de Identificación");
        gpVentanaBibliotecario.add(TipoIdentificacion, 0, 2);
         Tipoidentificacion = new TextField();
        gpVentanaBibliotecario.add(Tipoidentificacion, 1, 2);
        Label identificacion = new Label("Identificación");
        gpVentanaBibliotecario.add(identificacion, 0, 3);
        identi = new TextField();
        gpVentanaBibliotecario.add(identi, 1, 3);
        Label contraseña = new Label("Contraseña");
        gpVentanaBibliotecario.add(contraseña, 0, 4);
         contraseñ = new TextField();
        gpVentanaBibliotecario.add(contraseñ, 1, 4);
         Label tipoUsuar = new Label("Tipo de Usuario");
        gpVentanaBibliotecario.add(tipoUsuar, 0, 5);
         tipoUsuari = new TextField();
        gpVentanaBibliotecario.add(tipoUsuari, 1, 5);
//        Msj = new Label("");
           gpVentanaBibliotecario.add(btnAgregar, 0, 7);
//        gpVentanaBibliotecario.add(Msj,0,6);
    
        btnAgregar.setOnAction(new EventHandler<ActionEvent>() {
            
             public void handle(ActionEvent event) {
                 
                       
                if(verificaInfo() == true)
           JOptionPane.showMessageDialog(null, "Porfavor ingrese toda la informacion necesaria.");
                else{   
                 nombreUni = nombreUnic.getText();
                 nombreComple = nombreComplet.getText();
                 tipoIdentifica = Tipoidentificacion.getText();
                 identificacio = identi.getText();
                 contrase = contraseñ.getText();
                  tipoUsuario=tipoUsuari.getText();
                    Usuario usuario=new Usuario(contrase, contrase, nombreComple, tipoIdentifica, identificacio, tipoUsuario);
                 usuario.Agregar(usuario);
                JOptionPane.showMessageDialog(null,"Usuario agregado con exito :)");
                 Limpiar();
                
             }}
                       
              });
             
            
         return gpVentanaBibliotecario;
    } 
        
public void Limpiar(){
      nombreUnic.setText("");
      nombreComplet.setText("");
      Tipoidentificacion.setText("");
      identi.setText("");
      contraseñ .setText("");
      tipoUsuari.setText("");
            }
     
            //Metodo que verifica que todos los espacios de informacion esten llenos
     private boolean verificaInfo(){
         if(nombreUnic.getText().isEmpty())
             return true;
         else if(Tipoidentificacion.getText().isEmpty())
             return true;
         else if(nombreComplet.getText().isEmpty())
             return true;
         else if(identi.getText().isEmpty())
             return true;
         else if(contraseñ .getText().isEmpty())
             return true;
        
         else
             return false;
     }

       //Retorna interfaz del menu modificar
     public GridPane modificarUsuarios(){
        //Crea Gridpane
        GridPane modificaUsuario = new GridPane();
        modificaUsuario.setHgap(10);
        modificaUsuario.setVgap(10);
        modificaUsuario.setPadding(new Insets(20));
     
         //Crea Gridpane
        GridPane modificarUsuario = new GridPane();
        modificarUsuario.setHgap(10);
        modificarUsuario.setVgap(10);
        modificarUsuario.setPadding(new Insets(20));
        
        //Crea labels y textfields
        Label titulo = new Label("Actualizar Usuario");
        titulo.setFont(Font.font(17));
        
        Label usuarioModificar = new Label("Introduzca la identificacion");
        usuarioModificar.setFont(Font.font(17));
        
        identificacionModificar = new TextField();
        identificacionModificar.setPromptText("Identificacion");

        mensajes = new Label();
        mensajes.setFont(Font.font(17));
        
        identificacion = new Label("Cédula");
        identificacion.setFont(Font.font(17));
        mostarIdentificacion = new Label();
        mostarIdentificacion.setFont(Font.font(17));
        
        nombre = new Label("Nombre");
        nombre.setFont(Font.font(17));
        mostrarNombre = new Label();
        mostrarNombre.setFont(Font.font(17));
        
        Obra = new Label("Teléfono");
        Obra.setFont(Font.font(17));
        obra = new TextField();
        
        nombreUnico = new Label("Correo");
        nombreUnico.setFont(Font.font(17));
        nombreUnic= new TextField();
        
        contraseña = new Label("Residencia");
        contraseña.setFont(Font.font(17));
        contraseñ = new TextField();
        
        
        TipoUsuario = new Label("Dirección");
        TipoUsuario.setFont(Font.font(17));
        tipoUsuari = new TextField();
        
        //Oculta labels
        ocultaComponentes(false);
        
        CreayLeeArchivos cyla= new CreayLeeArchivos();
        
           Button verifica = new Button("Verificar");
        verifica.setFont(Font.font(17));
        //Pregunta si el usuario existe y muestra los componentes
        verifica.setOnAction(e -> {
           
            if(cyla.existeUsuario(identificacionModificar.getText(), "Usuarios.txt")){
                ocultaComponentes(true);
                modificarUsuario.setVisible(true);
                mensajes.setVisible(false);
                
                datosArchivo = cyla.getDatosEspecificos("Usuarios.txt", identificacionModificar.getText());
                
                mostarIdentificacion.setText(datosArchivo[0]);
                mostrarNombre.setText(datosArchivo[1]);
                obra.setText(datosArchivo[2]);
                nombreUnic.setText(datosArchivo[4]);
                contraseñ.setText(datosArchivo[5]);
                tipoUsuari.setText(datosArchivo[3]);
                mensajes.setVisible(false);
            }
            else{
                ocultaComponentes(false);
                mensajes.setText("El cliente no existe");
                modificarUsuario.setVisible(false);
            }
        });
        //Agrega componentes al Gridpane
        modificarUsuario.add(titulo, 1, 0);
        modificarUsuario.add(usuarioActualiar, 0, 1);
        modificarUsuario.add(identificacionModificar, 1, 1);
        modificarUsuario.add(verifica, 1, 2);
        modificarUsuario.add(identificacion, 0, 3);
        modificarUsuario.add(mensajes, 1, 3);
        modificarUsuario.add(mostarIdentificacion, 1, 3);
        modificarUsuario.add(nombre, 0, 4);
        modificarUsuario.add(mostrarNombre, 1, 4);
        modificarUsuario.add(TipoUsuario, 0, 5);
        modificarUsuario.add(tipoUsuari, 1, 5);
        modificarUsuario.add(nombreUnico, 0, 6);
        modificarUsuario.add(nombreUnic, 1, 6);
        modificarUsuario.add(Obra, 0, 7);
        modificarUsuario.add(obra, 1, 7);
        modificarUsuario.add(getButtonActualizarAutor(), 0, 8);
        
    return modificarUsuario;
    }//Fin modificarUsuarios
     public Button getButtonActualizarAutor(){
        //Crea boton
        actualizarUsuario = new Button("Modificar Usuario");
        actualizarUsuario.setFont(Font.font(17));
     actualizarUsuario.setVisible(false);
        
        //Actualiza los datos del autor
       actualizarUsuario.setOnAction(e -> {
          CreayLeeArchivos cyla= new CreayLeeArchivos();
            cyla.actualizarUsuario(mostrarIdentificacion.getText(), mostrarNombre.getText(), Tipoidentificacion.getText(),
                                   contraseñ.getText(), identi.getText(), nombreUnic.getText());
            mensajes.setVisible(true);
            mensajes.setText("El autor ha sido actualizado con exito");
            ocultaComponentes(false);
            identificacionModificar.setText("");
            actualizarUsuario.setVisible(false);
        });
    return  actualizarUsuario;
    }//Fin getButtonActualizarCliente
    
         
    //Oculta y muestra componentes
    public void ocultaComponentes(boolean visible){
        mostarIdentificacion.setVisible(visible);
        identificacion.setVisible(visible);
        mostrarNombre.setVisible(visible);
        nombre.setVisible(visible);
        nombreUnic.setVisible(visible);
        nombreUnico.setVisible(visible);
        contraseñ.setVisible(visible);
        contraseña.setVisible(visible);
        tipoUsuari.setVisible(visible);
        Tipoidentificacion.setVisible(visible);
        obra.setVisible(visible);
        Obra.setVisible(visible);
       
        //Limpia componentes
        if(!visible){
            mostarIdentificacion.setText("");
            mostrarNombre.setText("");
            contraseñ.setText("");
            identi.setText("");
            tipoUsuari.setText("");
            obra.setText("");
        }
    }//Fin ocultaComponentes
     
     
     
    
}
    



