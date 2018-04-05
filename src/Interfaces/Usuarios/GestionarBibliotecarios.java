/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Usuarios;

import domain.Bibliotecarios;
import domain.CreayLeeArchivos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
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
public class GestionarBibliotecarios {
    public String nombreUni;
    public String nombreComple;
    static String identificacio;
    static String tipoIdentifica;
    static String tipoUsuario;
    public String contrase;
    String []datosArchivo;
    TextField nombreUnic;
    TextField nombreComplet;
    TextField Tipoidentificacion, identificacionModificar, obra, mostrarIdentificacion;
    TextField identi;
    TextField contraseñ;
    TextField tipoUsuari;
    Button btnAgregar, actualizarBibliotecario;
    Label mensajes, identificacion, mostarIdentificacion,nombre, mostrarNombre,contraseña,nombreUnico,TipoUsuario,Obra, usuarioActualiar;

    
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
 
 
 //Retorna interfaz del menu modificar
     public GridPane modificarBibliotecario(){
        //Crea Gridpane
        GridPane modificaBibliotecario = new GridPane();
        modificaBibliotecario.setHgap(10);
        modificaBibliotecario.setVgap(10);
        modificaBibliotecario.setPadding(new Insets(20));
     
         //Crea Gridpane
        GridPane modificarBiliotecario = new GridPane();
        modificarBiliotecario.setHgap(10);
        modificarBiliotecario.setVgap(10);
        modificarBiliotecario.setPadding(new Insets(20));
        
        //Crea labels y textfields
        Label titulo = new Label("Modificar Bibliotecario");
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
           
            if(cyla.existeUsuario(identificacionModificar.getText(), "Bibliorecarios.txt")){
                ocultaComponentes(true);
                modificarBiliotecario.setVisible(true);
                mensajes.setVisible(false);
                
                datosArchivo = cyla.getDatosEspecificos("Bibliotecarios.txt", identificacionModificar.getText());
                
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
                modificarBiliotecario.setVisible(false);
            }
        });
        //Agrega componentes al Gridpane
        modificarBiliotecario.add(titulo, 1, 0);
        modificarBiliotecario.add(usuarioActualiar, 0, 1);
        modificarBiliotecario.add(identificacionModificar, 1, 1);
        modificarBiliotecario.add(verifica, 1, 2);
        modificarBiliotecario.add(identificacion, 0, 3);
        modificarBiliotecario.add(mensajes, 1, 3);
        modificarBiliotecario.add(mostarIdentificacion, 1, 3);
        modificarBiliotecario.add(nombre, 0, 4);
        modificarBiliotecario.add(mostrarNombre, 1, 4);
        modificarBiliotecario.add(TipoUsuario, 0, 5);
        modificarBiliotecario.add(tipoUsuari, 1, 5);
        modificarBiliotecario.add(nombreUnico, 0, 6);
        modificarBiliotecario.add(nombreUnic, 1, 6);
        modificarBiliotecario.add(Obra, 0, 7);
        modificarBiliotecario.add(obra, 1, 7);
        modificarBiliotecario.add(getButtonModificarBibliotecario(), 0, 8);
        
    return modificarBiliotecario;
    }//Fin modificarUsuarios
     public Button getButtonModificarBibliotecario(){
        //Crea boton
        actualizarBibliotecario = new Button("Modificar Bibliotecario");
       actualizarBibliotecario.setFont(Font.font(17));
     actualizarBibliotecario.setVisible(false);
        
        //Actualiza los datos del autor
       actualizarBibliotecario.setOnAction(e -> {
          CreayLeeArchivos cyla= new CreayLeeArchivos();
            cyla.actualizarUsuario(mostrarIdentificacion.getText(), mostrarNombre.getText(), Tipoidentificacion.getText(),
                                   contraseñ.getText(), identi.getText(), nombreUnic.getText());
            mensajes.setVisible(true);
            mensajes.setText("El bibliotecario ha sido actualizado con exito");
            ocultaComponentes(false);
            identificacionModificar.setText("");
            actualizarBibliotecario.setVisible(false);
        });
    return  actualizarBibliotecario;
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
