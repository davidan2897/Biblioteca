/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Usuarios;

import domain.Bibliotecarios;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class GestionarBibliotecarios {
    public String nombreUni;
    public String nombreComple;
    static String identificacio;
    static String tipoIdentifica;
    static String tipoUsuario;
    public String contrase;
    TextField nombreUnic;
    TextField nombreComplet;
    TextField Tipoidentificacion;
    TextField identi;
    TextField contraseñ;
    Button btnAgregar;
 TextField campoTextoUsuario;
    
   

    
     public GridPane interAddBibliotecario(){
      
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
               Bibliotecarios bi=new Bibliotecarios(nombreUni, contrase, nombreComple, tipoIdentifica, identificacio,tipoUsuario);
                bi.Agregar(bi);
                JOptionPane.showMessageDialog(null,"Bibliotecario agregado con exito :)");
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

     
          public  boolean verificarUsuario(Bibliotecarios [] B,String nombreunico,String contraseña){
         boolean encontrado=false;
        
        for(int i=0;i<B.length;i++){
            System.out.println(nombreunico);
            
            if(nombreunico.equals(B[i].getUnicoNombre())&&contraseña.equals(B[i].getContraseña())){
                encontrado=true;
                
                
                break;
            }
        
        }
       
         return encontrado;
         
     }
     public int CantidadRegistrosUsuarios() {//cuenta la cantidad de lineas que tiene el registro
        int cuentaRegistro = 0;
        try {
            BufferedReader br = getBufferedReader("Usuarios.txt");
            String registro = br.readLine();
            while (registro != null) {
                cuentaRegistro++;
                registro = br.readLine();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "error");
        }
        return cuentaRegistro;
    } 
    public Bibliotecarios [] arregloUsuarios() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Bibliotecarios elementosUsuarios[] = new Bibliotecarios[CantidadRegistrosUsuarios()];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Usuarios.txt");
            String registro = br.readLine();
            while (registro != null) {

              
                int controlaTokens = 1;
                String unicoNombre = "",contraseña = "",nombreCompleto = "",tipoIdentificacion = "",identificacion="",tipoUsuario="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        unicoNombre = st.nextToken();
                    } else if (controlaTokens == 2) {
                        contraseña = st.nextToken();
                    } else if (controlaTokens == 3) {
                        nombreCompleto = st.nextToken();
                    } else if (controlaTokens == 4) {
                        tipoIdentificacion = st.nextToken();
                    } else if (controlaTokens == 5) {
                        identificacion = st.nextToken();
                    }else if(controlaTokens==6){
                        tipoUsuario=st.nextToken();
                    }else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Bibliotecarios  B= new Bibliotecarios(unicoNombre, contraseña, nombreCompleto, tipoIdentificacion, identificacion,tipoUsuario);
                elementosUsuarios[indice] = B;
                indice++;
                registro = br.readLine();
            }//Fin del while 1

        }//Fin del try
        catch (FileNotFoundException fnfe) {
           
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }//Fin del catch 
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }

        return elementosUsuarios;
    }    
   
 public BufferedReader getBufferedReader(String nombrearchivo) {
        File archivo = new File(nombrearchivo);
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);

        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "error");
        }
        return br;
    } 
    
 public BorderPane ventanaBorrar(){
   
     BorderPane BorrarVentana = new BorderPane();
     GridPane ventanaCentroBorrar = new GridPane();
     HBox OrdenBotones = new HBox();
     Label etiquetaIngresoTipoUsuario = new Label("Tipo de Usuario:");
     Label Ordenartop = new Label("\n\n\n\n\n\n");
     Label Espacio = new Label("                ");
    ComboBox<String> comboBoxtipoUsuario = new ComboBox();
        comboBoxtipoUsuario.getItems().addAll("Usuario", "Autor", "Bibliotecario");
   
        Label etiquetaUsuario = new Label("Usuario:");
    campoTextoUsuario = new TextField();
    
    
     Button btnBorrar = new Button("Borrar");
     Button btnIngresar= new Button("Ingresar");
     Button btnCancelar = new Button("Cancelar");
     
     
      btnBorrar.setDisable(true);
        btnCancelar.setDisable(true);
        
        //Accion boton Ingresar
        btnIngresar.setOnAction((event) -> {
            
              tipoUsuario = comboBoxtipoUsuario.getValue();
              nombreUni= campoTextoUsuario.getText();
              if(nombreUni.isEmpty()==true)
                  JOptionPane.showMessageDialog(null,"No se ha ingresado ningun usuario" );
              else
     if(buscaUsuario(tipoUsuario, getArreglo(CantidadRegistrosUsuarios()), nombreUni  )==true){
         btnBorrar.setDisable(false);
         btnCancelar.setDisable(false);
         btnIngresar.setDisable(true);
         
     }
     else
    JOptionPane.showMessageDialog(null, "Usuario no se encuentra en registro");
          
        });//fin btnIngresar
        //Accion boton borrar
        btnBorrar.setOnAction((event) -> {
         
            eliminarUsuario(tipoUsuario, getArreglo(CantidadRegistrosUsuarios()), nombreUni);
            JOptionPane.showMessageDialog(null, "Usuario eliminado con exito");
             btnBorrar.setDisable(true);
             campoTextoUsuario.setText("");
             btnIngresar.setDisable(false);
             btnCancelar.setDisable(true);
        });//fin borrar
        btnCancelar.setOnAction((event) -> {
            campoTextoUsuario.setText("");
            btnBorrar.setDisable(true);
            btnCancelar.setDisable(true);
            btnIngresar.setDisable(false);
            
          });//fin botonCancelar
        
     OrdenBotones.getChildren().addAll(btnIngresar,btnBorrar,btnCancelar);
     
     
     ventanaCentroBorrar.add(etiquetaIngresoTipoUsuario, 0, 0);
     ventanaCentroBorrar.add(comboBoxtipoUsuario, 1, 0);
   
     ventanaCentroBorrar.add(etiquetaUsuario, 0, 2);
     ventanaCentroBorrar.add(campoTextoUsuario, 1, 2);

     ventanaCentroBorrar.add(OrdenBotones, 1, 4);
     
    
            
    BorrarVentana.setRight(Espacio);
    BorrarVentana.setTop(Ordenartop);
    BorrarVentana.setCenter(ventanaCentroBorrar);
    ventanaCentroBorrar.setAlignment(Pos.CENTER);

     
     
        return BorrarVentana;
     
     
     
     
 }//finVentanaCerrar
 
  public boolean buscaUsuario(String tipoUsuario, String a[],String usuario) {
        String tipoUsuarioArchivo = "", usuarioArchivo = "",  aux ="";
       
        boolean encontrado = false;
        for (int i = 0; i < a.length; i++) {
            aux = a[i];

            StringTokenizer st = new StringTokenizer(aux, ";");
          
            int controlaTokens = 1;
            while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) 
                        usuarioArchivo = st.nextToken();
                     else if (controlaTokens == 2) 
                        st.nextToken();
                     else if (controlaTokens == 3) 
                       st.nextToken();
                    else if (controlaTokens == 4) 
                         st.nextToken();
                     else if (controlaTokens == 5) 
                       st.nextToken();
                    else if(controlaTokens==6)
                     tipoUsuarioArchivo =  st.nextToken();
                   
                    controlaTokens++;
                //Fin del While 2;
            
            }
               
            
            if (tipoUsuario.equals(tipoUsuarioArchivo) && usuario.equalsIgnoreCase(usuarioArchivo)) {
                encontrado = true;
                break;
            }//fin if
            
     
        }//fin for i

        return encontrado;
    }//fin buscaClientes
  
  public String[] getArreglo(int cantidadRegistros) {
        File archivo = new File("Usuarios.txt");
        String array[] = new String[cantidadRegistros];
        String c;
        int i = 0;
        try {
            BufferedReader br = getBufferedReader("Usuarios.txt");
            c = br.readLine();

            while (i < cantidadRegistros) {
                array[i] = c;
                c = br.readLine();
                i++;
            }//fin while

        }//fin try
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas");

        }

        return array;

    }//fin getArreglo
  
 public void eliminarUsuario(String tipoUsuario, String a[],String Usuario) {
         String usuarios="",nombreUsuario;
       try{
           PrintStream ps = new PrintStream("Usuarios.txt");

            for (int i = 0; i < a.length; i++) {
                  usuarios= a[i];
               StringTokenizer sT = new StringTokenizer( usuarios, ";");
                 nombreUsuario =sT.nextToken();
                if (nombreUsuario.equals(Usuario)){ 
                   
                   usuarios = "-1";
                }
                if(!usuarios.equalsIgnoreCase("-1"))
                  ps.println(usuarios);
         
            }//fin for
           
     

    }//try
      
       catch(FileNotFoundException fnf){
                JOptionPane.showMessageDialog(null, "Un error ha pasado: Contacte con su administrador."); 
    }//fin catch
    
 
    }//fin eliminarUsuarios
 
}
