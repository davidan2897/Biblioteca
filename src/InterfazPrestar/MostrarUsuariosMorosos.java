/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazPrestar;

import Constructores.Prestar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;

/**
 *
 * @author UsuarioPC
 */
public class MostrarUsuariosMorosos {
    PrestarObras prestarObras;
     public VBox UsuariosMorosos(){
          
        TableView<Prestar> tabla=new TableView<>();
        
        
       
        TableColumn fechaPrestamo=new TableColumn("Fecha prestamo");
         fechaPrestamo.setCellValueFactory(new PropertyValueFactory("fechaPrestamo"));
        
        TableColumn fechaRetorno=new TableColumn("Fecha retorno");
        fechaRetorno.setCellValueFactory(new PropertyValueFactory<>("fechaRetorno"));
        TableColumn nombreUnico=new TableColumn("Nombre Unico");
        nombreUnico.setCellValueFactory(new PropertyValueFactory<>("nombreUnico"));
        TableColumn nombreObra=new TableColumn("Nombre obra");
        nombreObra.setCellValueFactory(new PropertyValueFactory<>("nombreObra"));
        TableColumn tipoObra=new TableColumn("Tipo Obra");
        tipoObra.setCellValueFactory(new PropertyValueFactory<>("tipoObra"));
        
        
        
        ObservableList<Prestar>datos=getDatosTabla();
        tabla.setItems(datos);
        tabla.getColumns().addAll(fechaPrestamo,fechaRetorno,nombreUnico,nombreObra,tipoObra);
         
        tabla.setMaxSize(500, 300);
        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        return vbox;
    }

     public ObservableList<Prestar> getDatosTabla(){
         
        java.util.Date fecha = new Date();
        ArrayList array=new ArrayList();
        //PrestarObras prestarObras=new PrestarObras();
       Prestar temp[]=arregloObrasPrestadas();
        //for(Prestar valor:temp)
            //array.add(valor);
            String  obtenerValor;
         int dia;
         int mes;
         int año;
         for(int i=0;i<temp.length;i++){
           //obtenerValor=temp[i].getFechaRetorno();
          //String obtenerMes=temp[i].getFechaRetorno();
           //dia=Integer.parseInt(obtenerValor.substring(0, 1));
           //mes=Integer.parseInt(obtenerMes.substring(3,3));
           dia=fecha.getDate();
           mes=fecha.getMonth();
           año=fecha.getYear();
           obtenerValor=dia + "/" + mes + "/" + año;
             if(temp[i].getFechaRetorno().compareTo(obtenerValor)<0||obtenerValor.compareTo(temp[i].getFechaRetorno())>0){
                array.add(temp[i]);
            }
                
                
           }
        
        
        ObservableList<Prestar> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
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
     public int CantidadRegistrosUsuarios() {//cuenta la cantidad de lineas que tiene el registro
        int cuentaRegistro = 0;
        try {
            BufferedReader br = getBufferedReader("ObrasPrestadas.txt");
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
     public Prestar [] arregloObrasPrestadas() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Prestar elementosUsuarios[] = new Prestar[CantidadRegistrosUsuarios()];
        int indice = 0;
        try {
            BufferedReader br =getBufferedReader("ObrasPrestadas.txt");
            String registro = br.readLine();
            while (registro != null) {

              
                int controlaTokens = 1;
                String fechaPrestamo = "",fechaRetorno = "",nombreUnico = "",nombreObra = "",tipoObra="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        fechaPrestamo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaRetorno = st.nextToken();
                    } else if (controlaTokens == 3) {
                        nombreUnico = st.nextToken();
                    } else if (controlaTokens == 4) {
                        nombreObra= st.nextToken();
                    } else if (controlaTokens == 5) {
                        tipoObra = st.nextToken();
                    }else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Prestar  Prestar= new Prestar(fechaPrestamo, fechaRetorno, nombreUnico, nombreObra, tipoObra);
                elementosUsuarios[indice] = Prestar;
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
}


