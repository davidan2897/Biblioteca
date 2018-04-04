/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Interfaces.Catalogo.GestionarLibros;
import Interfaces.Catalogo.GestionarMemorias;
import Interfaces.Catalogo.GestionarPeriodico;
import Interfaces.Catalogo.GestionarRevista;
import Interfaces.Catalogo.GestionarTesis;
import Interfaces.Usuarios.GestionarAutores;
import Interfaces.Usuarios.GestionarBibliotecarios;
import Interfaces.Usuarios.GestionarUsuarios;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author David
 */
public class PantallaBibliotecario {
    //instancias globales
      
    GestionarBibliotecarios gestioBibliotecarios = new GestionarBibliotecarios();
    GestionarAutores gestioAutores = new GestionarAutores();
    GestionarUsuarios gestioUsuarios=new GestionarUsuarios();
    GestionarMemorias interMemorias=new GestionarMemorias();
    GestionarPeriodico interPeriodico=new GestionarPeriodico();
    GestionarRevista interrevista = new GestionarRevista();
    GestionarLibros gestioLibros=new GestionarLibros();
    GestionarTesis gestioTesis = new GestionarTesis();
        public VBox InterBibliotecario() {

        VBox vbVentanas = new VBox();
        VBox Vboxbarra = new VBox();
        //menus
        MenuBar mbMenu = new MenuBar();
        Menu menuAgregar = new Menu(("Agregar"), new ImageView(new Image("mas.png")));
        menuAgregar.setMnemonicParsing(true);
        Menu menuBorrar = new Menu(("Borrar"), new ImageView(new Image("icDelete.png")));
        Menu menuModificar = new Menu(("Modificar"), new ImageView(new Image("actualizar.png")));
        Menu menuMostar = new Menu(("Mostar"), new ImageView(new Image("show.png")));
       Menu menuBuscar = new Menu(("Buscar"), new ImageView(new Image("buscar.png")));

        //MenusItemsUsuariosAgregar
         Menu menuUsuariosAg = new Menu("Usuarios");
        
        
        MenuItem UsuarioItemAg = new MenuItem("Usuarios");
        UsuarioItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioUsuarios.AgregarAutor());
            
        });
        MenuItem AutoresItemAg = new MenuItem("Autores");
        AutoresItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
                vbVentanas.getChildren().addAll(gestioAutores.AgregarAutor());
        });
        MenuItem BibliotecariosItemAg = new MenuItem("Bibliotecarios");
        BibliotecariosItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             
            vbVentanas.getChildren().addAll(gestioBibliotecarios.interAddBibliotecario());
        });
       //MenusItemsCatalogoAgregar
      Menu menuCatalogoAg = new Menu("Catalogo");
        MenuItem LibrosItemAg = new MenuItem("Libros");
        LibrosItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             
           vbVentanas.getChildren().addAll(gestioLibros.AgregarLibros());
        });
        MenuItem PeriodicosItemAg = new MenuItem("Periodicos");
        PeriodicosItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
           
              vbVentanas.getChildren().addAll(interPeriodico.AgregarPeriodico());
        });
        MenuItem RevistasItemAg = new MenuItem("Revistas");
        RevistasItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
               vbVentanas.getChildren().addAll(interrevista.AgregarRevista());
        });
        MenuItem TesisItemAg = new MenuItem("Tesis");
        TesisItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
       vbVentanas.getChildren().addAll(gestioTesis.AgregarTesis());
        });
        MenuItem MemoriasItemAg = new MenuItem("Memorias");
        MemoriasItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
                vbVentanas.getChildren().addAll(interMemorias.AgregarMemorias());
        });

        //MenusItemBorrar
       
        Menu menuCatalogoBo = new Menu("Catalogo");

        MenuItem UsuarioItemBo = new MenuItem("Usuarios");
        UsuarioItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioBibliotecarios.ventanaBorrar());
        });
       
        //MenusItemBorrar
      
        
        
  
      
        //MenusItemsCatalogoBorrar

        MenuItem LibrosItemBo = new MenuItem("Libros");
        LibrosItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem PeriodicosItemBo = new MenuItem("Periodicos");
        PeriodicosItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem RevistasItemBo = new MenuItem("Revistas");
        RevistasItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem TesisItemBo = new MenuItem("Tesis");
        TesisItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem MemoriasItemBo = new MenuItem("Memorias");
        MemoriasItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
         //MenusItemActualizar
        Menu menuUsuariosAc = new Menu("Usuarios");
        Menu menuCatalogoAc = new Menu("Catalogo");

        MenuItem UsuarioItemAc = new MenuItem("Usuarios");
        UsuarioItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
          
        });
        MenuItem AutoresItemAc = new MenuItem("Autores");
        AutoresItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem BibliotecariosItemAc = new MenuItem("Bibliotecarios");
        BibliotecariosItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        //MenusItemsCatalogoActualizar

        MenuItem LibrosItemAc = new MenuItem("Libros");
        LibrosItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem PeriodicosItemAc = new MenuItem("Periodicos");
         PeriodicosItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem RevistasItemAc = new MenuItem("Revistas");
        RevistasItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem TesisItemAc = new MenuItem("Tesis");
        TesisItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        MenuItem MemoriasItemAc = new MenuItem("Memorias");
        MemoriasItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();

        });
        
       
     
        
        
        
        menuCatalogoAc.getItems().addAll(LibrosItemAc, RevistasItemAc, PeriodicosItemAc, TesisItemAc, MemoriasItemAc);
        menuUsuariosAc.getItems().addAll(UsuarioItemAc, AutoresItemAc, BibliotecariosItemAc);
        menuCatalogoBo.getItems().addAll(LibrosItemBo, RevistasItemBo, PeriodicosItemBo, TesisItemBo, MemoriasItemBo);
        menuCatalogoAg.getItems().addAll(LibrosItemAg, RevistasItemAg, PeriodicosItemAg, TesisItemAg, MemoriasItemAg);
        menuUsuariosAg.getItems().addAll(UsuarioItemAg, AutoresItemAg, BibliotecariosItemAg);
         menuModificar.getItems().addAll(menuUsuariosAc, menuCatalogoAc);
        menuAgregar.getItems().addAll(menuUsuariosAg, menuCatalogoAg);
        menuBorrar.getItems().addAll(UsuarioItemBo, menuCatalogoBo);

        mbMenu.getMenus().addAll(menuAgregar, menuBorrar, menuModificar, menuMostar,menuBuscar);
       
        Vboxbarra.getChildren().addAll(mbMenu,vbVentanas);
        return Vboxbarra;

    }
}

