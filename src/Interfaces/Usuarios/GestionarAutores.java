package Interfaces.Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import domain.Autores;
import domain.Bibliotecarios;
import domain.CreayLeeArchivos;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GestionarAutores {
     public String nombreUni;
    public String nombreComple;
     static String identificacio;
      static String tipoIdentifica;
    public String contrase;
      static String tipoUsuario;
      String []datosArchivo;
    TextField nombreUnic ;
    TextField nombreComplet;
    TextField Tipoidentificacion, identificacionActualizar, obra, mostrarIdentificacion;
    TextField identi;
    TextField contraseñ;
    TextField tipoUsuari ;
    Button btnAgregar, modificarAutor;
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
                 Autores au = new Autores(nombreUni, contrase, nombreComple, tipoIdentifica, identificacio,tipoUsuario);
                 au.Agregar(au);
                JOptionPane.showMessageDialog(null,"Autor agregado con exito :)");
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
     public GridPane modificarAutor(){
        //Crea Gridpane
        GridPane gd_modificaAutor = new GridPane();
        gd_modificaAutor.setHgap(10);
        gd_modificaAutor.setVgap(10);
        gd_modificaAutor.setPadding(new Insets(20));
     
         //Crea Gridpane
        GridPane actualizaAutor = new GridPane();
        actualizaAutor.setHgap(10);
        actualizaAutor.setVgap(10);
        actualizaAutor.setPadding(new Insets(20));
        
        //Crea labels y textfields
        Label titulo = new Label("Modificar Autor");
        titulo.setFont(Font.font(17));
        
        Label usuarioActualizar = new Label("Introduzca la identificacion");
        usuarioActualizar.setFont(Font.font(17));
        
        identificacionActualizar = new TextField();
        identificacionActualizar.setPromptText("Identificacion");

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
           
            if(cyla.existeUsuario(identificacionActualizar.getText(), "Autores.txt")){
                ocultaComponentes(true);
                modificarAutor.setVisible(true);
                mensajes.setVisible(false);
                
                datosArchivo = cyla.getDatosEspecificos("Autores.txt", identificacionActualizar.getText());
                
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
                mensajes.setText("El autor no existe");
                modificarAutor.setVisible(false);
            }
        });
        //Agrega componentes al Gridpane
        actualizaAutor.add(titulo, 1, 0);
        actualizaAutor.add(usuarioActualiar, 0, 1);
        actualizaAutor.add(identificacionActualizar, 1, 1);
        actualizaAutor.add(verifica, 1, 2);
        actualizaAutor.add(identificacion, 0, 3);
        actualizaAutor.add(mensajes, 1, 3);
        actualizaAutor.add(mostarIdentificacion, 1, 3);
        actualizaAutor.add(nombre, 0, 4);
        actualizaAutor.add(mostrarNombre, 1, 4);
        actualizaAutor.add(TipoUsuario, 0, 5);
        actualizaAutor.add(tipoUsuari, 1, 5);
        actualizaAutor.add(nombreUnico, 0, 6);
        actualizaAutor.add(nombreUnic, 1, 6);
        actualizaAutor.add(Obra, 0, 7);
        actualizaAutor.add(obra, 1, 7);
        actualizaAutor.add(getButtonActualizarAutor(), 0, 8);
        
    return actualizaAutor;
    }//Fin modificarAutor
     public Button getButtonActualizarAutor(){
        //Crea boton
        
        modificarAutor= new Button("Actualizar Autor");
        modificarAutor.setFont(Font.font(17));
     modificarAutor.setVisible(false);
        
        //Actualiza los datos del autor
       modificarAutor.setOnAction(e -> {
          CreayLeeArchivos cyla= new CreayLeeArchivos();
            cyla.actualizarUsuario(mostrarIdentificacion.getText(), mostrarNombre.getText(), Tipoidentificacion.getText(),
                                   contraseñ.getText(), identi.getText(), nombreUnic.getText());
            mensajes.setVisible(true);
            mensajes.setText("El autor ha sido actualizado con exito");
            ocultaComponentes(false);
            identificacionActualizar.setText("");
            modificarAutor.setVisible(false);
        });
    return  modificarAutor;
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
    

     
    

    

