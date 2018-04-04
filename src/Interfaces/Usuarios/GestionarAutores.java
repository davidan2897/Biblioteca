package Interfaces.Usuarios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static Interfaces.Usuarios.GestionarBibliotecarios.tipoIdentifica;
import domain.Autores;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    TextField nombreUnic ;
    TextField nombreComplet;
    TextField Tipoidentificacion;
    TextField identi;
    TextField contraseñ;
    Button btnAgregar;
    
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
        TextField tipoUsuari = new TextField();
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

     
    
}
    

