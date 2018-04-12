/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PantallasPrincipales;

import Interfaces.Catalogo.BuscarObra;
import Interfaces.Catalogo.GestionarLibros;
import Interfaces.Catalogo.GestionarMemorias;
import Interfaces.Catalogo.GestionarPeriodico;
import Interfaces.Catalogo.GestionarRevista;
import Interfaces.Catalogo.GestionarTesis;
import Interfaces.Usuarios.GestionarAutores;
import Interfaces.Usuarios.GestionarBibliotecarios;
import Interfaces.Usuarios.GestionarUsuarios;
import InterfazPrestar.MostrarListaObrasPrestadas;
import InterfazPrestar.MostrarObrasTodas;
import InterfazPrestar.MostrarUsuariosMorosos;
import InterfazPrestar.PrestarObras;
import Interfaces.Catalogo.ModificarObras;
import Interfaces.Catalogo.ModificarUsuario;
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
    GestionarMemorias gestioMemorias=new GestionarMemorias();
    GestionarPeriodico gestioPeriodico=new GestionarPeriodico();
    GestionarRevista gestioRevista = new GestionarRevista();
    GestionarLibros gestioLibros=new GestionarLibros();
    GestionarTesis gestioTesis = new GestionarTesis();
    BuscarObra buscarObra = new BuscarObra();
    PrestarObras prestarObra = new PrestarObras();
    MostrarListaObrasPrestadas mostarListObrasPrestadas = new MostrarListaObrasPrestadas();
    MostrarObrasTodas mostarTodasObras = new MostrarObrasTodas();
    MostrarUsuariosMorosos mostarUsuariosMorosos = new MostrarUsuariosMorosos();
      ModificarObras modificarObras= new ModificarObras();
       ModificarUsuario modificar = new ModificarUsuario();
      
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
       Menu menuPrestar = new Menu(("Prestar"), new ImageView(new Image("prestar.png")));
       

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
           
              vbVentanas.getChildren().addAll(gestioPeriodico.AgregarPeriodico());
        });
        MenuItem RevistasItemAg = new MenuItem("Revistas");
        RevistasItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
               vbVentanas.getChildren().addAll(gestioRevista.AgregarRevista());
        });
        MenuItem TesisItemAg = new MenuItem("Tesis");
        TesisItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
       vbVentanas.getChildren().addAll(gestioTesis.AgregarTesis());
        });
        MenuItem MemoriasItemAg = new MenuItem("Memorias");
        MemoriasItemAg.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
                vbVentanas.getChildren().addAll(gestioMemorias.AgregarMemorias());
        });

        //MenusItemBorrar
       
        Menu menuCatalogoBo = new Menu("Catalogo");

        MenuItem UsuarioItemBo = new MenuItem("Usuarios");
        UsuarioItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioBibliotecarios.ventanaBorrar());
        });
       
        //MenusItemsCatalogoBorrar

        MenuItem LibrosItemBo = new MenuItem("Libros");
        LibrosItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioLibros.ventanaBorrarLibro());

        });
        MenuItem PeriodicosItemBo = new MenuItem("Periodicos");
        PeriodicosItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioPeriodico.ventanaBorrarPeriodico());

        });
        MenuItem RevistasItemBo = new MenuItem("Revistas");
        RevistasItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioRevista.ventanaBorrarRevista());

        });
        MenuItem TesisItemBo = new MenuItem("Tesis");
        TesisItemBo.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
            vbVentanas.getChildren().addAll(gestioTesis.ventanaBorrarTesis());

        });
        MenuItem MemoriasItemBo = new MenuItem("Memorias");
        MemoriasItemBo.setOnAction((event) -> {
              vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(gestioMemorias.ventanaBorrarMemoria());
          

        });
         //MenusItemActualizar

        Menu menuCatalogoAc = new Menu("Catalogo");

        MenuItem UsuarioItemAc = new MenuItem("Usuarios");
        UsuarioItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
              vbVentanas.getChildren().addAll(modificar.interModificar());
          
        });

        MenuItem LibrosItemAc = new MenuItem("Libros");
        LibrosItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
  vbVentanas.getChildren().addAll(modificarObras.interModificarLibros());
        });
        MenuItem PeriodicosItemAc = new MenuItem("Periodicos");
         PeriodicosItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
              vbVentanas.getChildren().addAll(modificarObras.interModificarPeriodicos());

        });
        MenuItem RevistasItemAc = new MenuItem("Revistas");
        RevistasItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
  vbVentanas.getChildren().addAll(modificarObras.interModificarRevistas());
        });
        MenuItem TesisItemAc = new MenuItem("Tesis");
        TesisItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
  vbVentanas.getChildren().addAll(modificarObras.interModificarTesis());
        });
        MenuItem MemoriasItemAc = new MenuItem("Memorias");
        MemoriasItemAc.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
  vbVentanas.getChildren().addAll(modificarObras.interModificarMemorias());
        });
        
       MenuItem ObraItemBuscar = new MenuItem("Obra");
     ObraItemBuscar.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(buscarObra.buscarObra());
        });
     
       MenuItem ObraItemPrestar = new MenuItem("Obra");
     ObraItemPrestar.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(prestarObra.prestarObras());
        });
     MenuItem ListaObrasItemMostrar = new MenuItem("Obras Prestadas");
        ListaObrasItemMostrar.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(mostarListObrasPrestadas.clientesListado());
        });
        MenuItem MostrarTodasObrasItem = new MenuItem("Todas las obras");
        MostrarTodasObrasItem.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(mostarTodasObras.MostarTodasObras());
        });
         MenuItem MostrarUsuariosMorososItem= new MenuItem("Usuarios morosos");
         MostrarUsuariosMorososItem.setOnAction((event) -> {
            vbVentanas.getChildren().clear();
             vbVentanas.getChildren().addAll(mostarUsuariosMorosos.UsuariosMorosos());
        });
        
        
        menuCatalogoAc.getItems().addAll(LibrosItemAc, RevistasItemAc, PeriodicosItemAc, TesisItemAc, MemoriasItemAc);
        menuCatalogoBo.getItems().addAll(LibrosItemBo, RevistasItemBo, PeriodicosItemBo, TesisItemBo, MemoriasItemBo);
        menuCatalogoAg.getItems().addAll(LibrosItemAg, RevistasItemAg, PeriodicosItemAg, TesisItemAg, MemoriasItemAg);
        menuUsuariosAg.getItems().addAll(UsuarioItemAg, AutoresItemAg, BibliotecariosItemAg);
        menuModificar.getItems().addAll(UsuarioItemAc, menuCatalogoAc);
        menuAgregar.getItems().addAll(menuUsuariosAg, menuCatalogoAg);
        menuBorrar.getItems().addAll(UsuarioItemBo, menuCatalogoBo);
        menuBuscar.getItems().addAll(ObraItemBuscar);
        menuPrestar.getItems().addAll(ObraItemPrestar);
        menuMostar.getItems().addAll(MostrarTodasObrasItem,ListaObrasItemMostrar,MostrarUsuariosMorososItem);

        mbMenu.getMenus().addAll(menuAgregar, menuBorrar, menuBuscar,menuModificar, menuMostar,menuPrestar);
         String image = "images.jpg";
        Vboxbarra.setStyle("-fx-background-image: url('" + image + "'); "
                 +"-fx-background-position: center;"
                 +"-fx-background-repeat: no-repeat;");
       
        Vboxbarra.getChildren().addAll(mbMenu,vbVentanas);

        return Vboxbarra ;

    }
}

