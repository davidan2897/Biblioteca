/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

 //David
import PantallasPrincipales.PantallaBibliotecario;
import Interfaces.Usuarios.GestionarBibliotecarios;
import PantallasPrincipales.PantallaAutor;
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
 
    PantallaBibliotecario pantallabibliotecario = new PantallaBibliotecario();
    PantallaAutor pantallaAutor = new PantallaAutor();
    PantallaAutor pantallaUsuario = new PantallaAutor();
    public static String valor;


     GestionarBibliotecarios gestBiblio;
     TextField tfUsuario ;
      TextField tfContraseña;
      PasswordField passUsuario;
      String NombreUnicoAutor;
      
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
                    
                    
                    Scene temScene = btnConfirmar.getScene();
                    temScene.setRoot(pantallabibliotecario.InterBibliotecario());
                    
                    ((Stage) temScene.getWindow()).setWidth(600);
                    ((Stage) temScene.getWindow()).setHeight(400);
                    ((Stage) temScene.getWindow()).setTitle("Biblioteca");
                    ((Stage) temScene.getWindow()).setResizable(false);
                    
                }
                if(cbtipoUsuario.getValue().toString().equalsIgnoreCase("Autor")) {
                    NombreUnicoAutor=tfUsuario.getText();
                 Scene temScene = btnConfirmar.getScene();
                 valor=tfUsuario.getText();
                    temScene.setRoot(pantallaAutor.interfazAutor());
                    
                    ((Stage) temScene.getWindow()).setWidth(600);
                    ((Stage) temScene.getWindow()).setHeight(400);
                    ((Stage) temScene.getWindow()).setTitle("Biblioteca");
                    ((Stage) temScene.getWindow()).setResizable(false);
            }
                if(cbtipoUsuario.getValue().toString().equalsIgnoreCase("Usuario")) {
                 Scene temScene = btnConfirmar.getScene();
                    temScene.setRoot(pantallaUsuario.interfazAutor());
                    
                    ((Stage) temScene.getWindow()).setWidth(600);
                    ((Stage) temScene.getWindow()).setHeight(400);
                    ((Stage) temScene.getWindow()).setTitle("Biblioteca");
                    ((Stage) temScene.getWindow()).setResizable(false);
            }
            } else{
                JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecta");
            }
          
        });//fin acc
        
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
         String image = "inicioSesion.png";
        
         vbox.setStyle("-fx-background-image: url('" + image + "'); "
                 + "-fx-background-position:bottom center;"
                 + "-fx-background-repeat: no-repeat;");
         vbox.getChildren().addAll(lbBiblioteca, ventanaInicio);

         return vbox;
        
        
    }//fin vbox
    
    @Override
    public void start( Stage primaryStage ) {
        Scene scene = new Scene(vbox(), 300, 200);
         
        primaryStage.setTitle("Iniciar Sesion");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        
                    
    }

    public static void main(String[] args) {
        launch(args);
    }
    }
