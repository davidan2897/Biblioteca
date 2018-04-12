/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazPrestar;

import Constructores.Prestar;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 *
 * @author UsuarioPC
 */
public class MostrarListaObrasPrestadas {
    Prestar prestar;
    
   public VBox clientesListado(){
          
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
        ArrayList array=new ArrayList();
        PrestarObras prestarObras=new PrestarObras();
       Prestar temp[]=prestarObras.arregloObrasPrestadas();
        for(Prestar valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Prestar> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }   
}
