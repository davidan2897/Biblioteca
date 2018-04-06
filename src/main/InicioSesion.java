/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import PantallasPrincipales.PantallaBibliotecario;
import Interfaces.Usuarios.GestionarBibliotecarios;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class InicioSesion extends Application {
    
    //instancias globales
    
    PantallaBibliotecario pantbiblio = new PantallaBibliotecario();
    Stage primaryStage = new Stage();
 
//    Stage secondStage = new Stage();
    Scene scene = new Scene(vbox(), 300, 200);
     GestionarBibliotecarios gestBiblio;
     TextField tfUsuario ;
      TextField tfContraseña;
      PasswordField passUsuario;
      
     public VBox vbox(){
        GridPane ventanaInicio = new GridPane();
        VBox vbox = new VBox();
     
      
        
        Label lbBiblioteca = new Label("Bienvenido al Sistema Virtual de la Biblioteca UCR");
        Label lbtipoUsuario = new Label("Tipo usuario:");
        ComboBox<String> cbtipoUsuario = new ComboBox();
        cbtipoUsuario.getItems().addAll("Usuario", "Autor", "Bibliotecario");
   
        Label lbUsuario = new Label("Usuario");
       
       
      
        Label lbContraseña = new Label("Contraseña");
        Button btnConfirmar= new Button("Confirmar");
        btnConfirmar.setOnAction((event) -> {
            gestBiblio=new GestionarBibliotecarios();
            String contraseña=passUsuario.getText();
          
            String usuario=tfUsuario.getText();
            boolean estado=gestBiblio.verificarUsuario(gestBiblio.arregloUsuarios(),usuario, contraseña);
            if(estado==true){
            if(cbtipoUsuario.getValue().toString().equalsIgnoreCase("Bibliotecario")) {
                //scene = new Scene(pantbiblio.InterBibliotecario(),400,500);
                 //primaryStage.getScene().setRoot(pantbiblio.InterBibliotecario());
                 scene.setRoot(pantbiblio.InterBibliotecario());
          primaryStage.setScene(scene);
//          secondStage.setTitle("Biblioteca");
//          secondStage.show();
               primaryStage.show();
            }
            } else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta");
            }
        });
        
        tfUsuario = new TextField();
        //tfContraseña = new TextField();
        passUsuario=new PasswordField();
     

        
        ventanaInicio.add(lbtipoUsuario, 0, 0);
        ventanaInicio.add(cbtipoUsuario, 1, 0);
        ventanaInicio.add(lbUsuario, 0, 1);
        ventanaInicio.add(tfUsuario, 1, 1);
        ventanaInicio.add(lbContraseña, 0, 4);
        ventanaInicio.add(passUsuario, 1, 4);
        ventanaInicio.add(btnConfirmar, 0, 5);
        
        vbox.getChildren().addAll( lbBiblioteca,ventanaInicio);
        
        return vbox;
        
        
    }//fin vbox
    
    @Override
    public void start( Stage primaryStage) {
      
        primaryStage.setTitle("Inicio Sesion Biblioteca");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    }
