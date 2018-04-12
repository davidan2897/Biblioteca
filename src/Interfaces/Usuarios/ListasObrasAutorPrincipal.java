/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Usuarios;

import InterfazPrestar.MostrarObrasTodas;
import Constructores.Bibliotecarios;
import Constructores.Libros;
import Constructores.Memorias;
import Constructores.Periodicos;
import Constructores.Revistas;
import Constructores.Tesis;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import main.InicioSesion;

/**
 *
 * @author UsuarioPC
 */
public class ListasObrasAutorPrincipal {
    MostrarObrasTodas mostrarObras=new MostrarObrasTodas();
   GestionarBibliotecarios gestionarBibliotecarios=new GestionarBibliotecarios();
    InicioSesion inicio;
     public VBox MostrarListalibros(){
          
        TableView<Libros> tabla=new TableView<>();
        
        
       
        TableColumn titulo=new TableColumn("Titulo");
         titulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        
        TableColumn fechaIngreso=new TableColumn("Fecha Ingreso");
        fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        TableColumn autor=new TableColumn("Autor");
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        TableColumn codigoISBN=new TableColumn("Codigo ISBN");
        codigoISBN.setCellValueFactory(new PropertyValueFactory<>("codigoISBN"));
        TableColumn  tema=new TableColumn("Tema");
        tema.setCellValueFactory(new PropertyValueFactory<>("tema"));
         TableColumn  subtema=new TableColumn("Subtema");
        subtema.setCellValueFactory(new PropertyValueFactory<>("subtema"));
         TableColumn estado=new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        
        ObservableList<Libros>datos=getDatosTabla();
        tabla.setItems(datos);
        tabla.getColumns().addAll(titulo,fechaIngreso,autor,codigoISBN,tema,subtema,estado);
//        tabla.getColumns().addAll(precio);
//        tabla.getColumns().addAll(modelo);
//        tabla.getColumns().addAll(marca);
//        tabla.getColumns().addAll(categoria);
//        tabla.getColumns().addAll(descripcion);



VBox root = new VBox();


        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        return vbox;
    }

     public ObservableList<Libros> getDatosTabla(){
        ArrayList array=new ArrayList();
       
       Libros temp[]=mostrarObras.arregloLibros();
       // for(Libros valor:temp)
           // array.add(valor);
            for(int i=0;i<temp.length;i++){
                System.out.println(inicio.valor);
                   if(temp[i].getAutor().equalsIgnoreCase(Valor(inicio.valor))){
                       array.add(temp[i]);
                      
                       
                   }
              }
         
        
        
        ObservableList<Libros> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    } 
     public String Valor(String val){
         String valor="";
         Bibliotecarios temp[]=gestionarBibliotecarios.arregloUsuarios();
         for(int i=0;i<temp.length;i++){
                 
                   if(temp[i].getUnicoNombre().equalsIgnoreCase(val)){
                   
                      valor=temp[i].getNombreCompleto();
                       
                   }
              }
         return valor;
     }
     public VBox MostrarListaMemorias(){
          
        TableView<Memorias> tabla=new TableView<>();
        
        
       
        TableColumn titulo=new TableColumn("Titulo");
         titulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        
        TableColumn fechaIngreso=new TableColumn("Fecha Ingreso");
        fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        TableColumn autor=new TableColumn("Autor");
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        TableColumn resumen=new TableColumn("Resumen");
        resumen.setCellValueFactory(new PropertyValueFactory<>("resumen"));
        TableColumn  Abstract=new TableColumn("Abstract");
        Abstract.setCellValueFactory(new PropertyValueFactory<>("Abstract"));
         TableColumn  conferenciaPresentada=new TableColumn("Conferencia Presentada");
        conferenciaPresentada.setCellValueFactory(new PropertyValueFactory<>("conferenciaPresentada"));
         TableColumn estado=new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        
        ObservableList<Memorias>datos=getDatosTabl();
        tabla.setItems(datos);
        tabla.getColumns().addAll(titulo,fechaIngreso,autor,resumen,Abstract,conferenciaPresentada,estado);
  tabla.setMaxSize(400, 200);






        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
         vbox.setMaxSize(500, 600);
        return vbox;
    }
         public ObservableList<Memorias> getDatosTabl(){
        ArrayList array=new ArrayList();
       
       Memorias temp[]=mostrarObras.arregloMemorias();
       // for(Libros valor:temp)
           // array.add(valor);
            for(int i=0;i<temp.length;i++){
                System.out.println(inicio.valor);
                   if(temp[i].getAutor().equalsIgnoreCase(Valor(inicio.valor))){
                       array.add(temp[i]);
                      
                       
                   }
              }
        
        
        ObservableList<Memorias> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
         public VBox MostrarListaPeriodicos(){
          
        TableView<Periodicos> tabla=new TableView<>();
        
        
       
        TableColumn titulo=new TableColumn("Titulo");
         titulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        
        TableColumn fechaIngreso=new TableColumn("Fecha Ingreso");
        fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        TableColumn Autor=new TableColumn("Autor");
        Autor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        TableColumn CodigoISSN=new TableColumn("Código ISSN");
        CodigoISSN.setCellValueFactory(new PropertyValueFactory<>("CodigoISSN"));
        TableColumn  Edicion=new TableColumn("Edición");
        Edicion.setCellValueFactory(new PropertyValueFactory<>("Edicion"));
         TableColumn  Fecha=new TableColumn("Fecha");
        Fecha.setCellValueFactory(new PropertyValueFactory<>("Fecha"));
         TableColumn estado=new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
        
        ObservableList<Periodicos>datos=getDatos();
        tabla.setItems(datos);
        tabla.getColumns().addAll(titulo,fechaIngreso,Autor,CodigoISSN,Edicion,Fecha,estado);
  tabla.setMaxSize(400, 200);





        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
         vbox.setMaxSize(500, 600);
        return vbox;
    }
          public ObservableList<Periodicos> getDatos(){
        ArrayList array=new ArrayList();
       
       Periodicos temp[]=mostrarObras.arregloPeriodico();
         for(int i=0;i<temp.length;i++){
                System.out.println(inicio.valor);
                   if(temp[i].getAutor().equalsIgnoreCase(Valor(inicio.valor))){
                       array.add(temp[i]);
                      
                       
                   }
              }
        
        
        ObservableList<Periodicos> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
           public VBox MostrarListaRevistas(){
          
        TableView<Revistas> tabla=new TableView<>();
        
        
       
        TableColumn titulo=new TableColumn("Titulo");
         titulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        
        TableColumn fechaIngreso=new TableColumn("Fecha Ingreso");
        fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        TableColumn autor=new TableColumn("Autor");
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        TableColumn codigoISSN=new TableColumn("Código ISSN");
        codigoISSN.setCellValueFactory(new PropertyValueFactory<>("codigoISSN"));
        TableColumn  edicion=new TableColumn("Edición");
        edicion.setCellValueFactory(new PropertyValueFactory<>("edicion"));
         TableColumn estado=new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
       
        ObservableList<Revistas>datos=getDatoss();
        tabla.setItems(datos);
        tabla.getColumns().addAll(titulo,fechaIngreso,autor,codigoISSN,edicion,estado);
  tabla.setMaxSize(400, 200);






        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        vbox.setMaxSize(500, 600);
        return vbox;
    }
          public ObservableList<Revistas> getDatoss(){
        ArrayList array=new ArrayList();
       
       Revistas temp[]=mostrarObras.arregloRevistas();
       for(int i=0;i<temp.length;i++){
                System.out.println(inicio.valor);
                   if(temp[i].getAutor().equalsIgnoreCase(Valor(inicio.valor))){
                       array.add(temp[i]);
                      
                       
                   }
              }
        
        ObservableList<Revistas> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
           public VBox MostrarListaTesis(){
          
        TableView<Tesis> tabla=new TableView<>();
        
        
       
        TableColumn titulo=new TableColumn("Titulo");
         titulo.setCellValueFactory(new PropertyValueFactory("titulo"));
        
        TableColumn fechaIngreso=new TableColumn("Fecha Ingreso");
        fechaIngreso.setCellValueFactory(new PropertyValueFactory<>("fechaIngreso"));
        TableColumn autor=new TableColumn("Autor");
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        TableColumn Resumen=new TableColumn("Resumen");
        Resumen.setCellValueFactory(new PropertyValueFactory<>("Resumen"));
        TableColumn  Abstract=new TableColumn("Abstract");
        Abstract.setCellValueFactory(new PropertyValueFactory<>("Abstract"));
         TableColumn estado=new TableColumn("Estado");
        estado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        
    
        ObservableList<Tesis>datos=getDat();
        tabla.setItems(datos);
        tabla.getColumns().addAll(titulo,fechaIngreso,autor,Resumen,Abstract,estado);
  tabla.setMaxSize(400, 200);




        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        vbox.setMaxSize(500, 600);
        return vbox;
    }
          public ObservableList<Tesis> getDat(){
        ArrayList array=new ArrayList();
       
       Tesis temp[]=mostrarObras.arregloTesis();
        for(int i=0;i<temp.length;i++){
                System.out.println(inicio.valor);
                   if(temp[i].getAutor().equalsIgnoreCase(Valor(inicio.valor))){
                       array.add(temp[i]);
                      
                       
                   }
              }
        
        
        ObservableList<Tesis> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
}
