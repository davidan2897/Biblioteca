/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PantallasPrincipales;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 *
 * @author Michelle
 */
//public class InterAutor {
//    //Retorna un Vbox con la tabla clientes  
//    public VBox mostrarTablaAutor(){
        
//        /*Aqui ponemos el nombre del archivo, puse el mismo ejemplo que en el de usuario
//        CreaYLeeArchivos=cyla;
//        */
//        
//        TableView <Autores> tabla = new TableView<>();
//        
//        /*cyla = new CreaYLeeArchivos();
//        Aqui lo instanciamos
//        */
//     
//        //Crea la columna Nombre Autor
//        TableColumn nombreAutorColum = new TableColumn("Nombre Autor");
//        nombreAutorColum.setCellValueFactory(new PropertyValueFactory<>("nombre autor"));
//        
//        //Crear columna con la lista de libros del autor
//        TableColumn ListaLibrosColum = new TableColumn("Libros");
//        ListaLibrosColum.setMinWidth(50);
//        ListaLibrosColum.setCellValueFactory(new PropertyValueFactory<>("Libros"));
//        
//         
//        //Mostrar los datos de las filas
//        /*
//        Aqui llamamos a lo que ocupamos del archivo
//        Por ejemplo puse getListado
//        */
//        ObservableList<Autores> datos = getListado();
//        tabla.setItems(datos);
//        
//           
//        tabla.getColumns().addAll(nombreAutorColum,ListaLibrosColum);
//        
//        VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(tabla);
//        
//    return vbox;
//    }//Fin mostrar tableview
//    
////Retorna un ObservableList de usuarios
//    public ObservableList<Autores> getListaAutor(){
//        
//        
//        ArrayList array = new ArrayList();
//        
//        
//        //cyla es el ejemplo que puse como archivo archivo
//        Usuario temp[] = cyla.leeAutoresArchivo();
//        
//        for(Autores a: temp)
//            array.add(a);
//        
//        ObservableList<Usuario> listadoAutor = FXCollections.observableArrayList(array);
//        
//    return listadoAutor;
//    }//Fin getListaAutor
    
//}
