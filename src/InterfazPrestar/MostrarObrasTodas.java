/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazPrestar;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import Constructores.Libros;
import Constructores.Memorias;
import Constructores.Periodicos;
import Constructores.Revistas;
import Constructores.Tesis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;
/**
 *
 * @author UsuarioPC
 */
public class MostrarObrasTodas {
    
   
   
     public BorderPane MostarTodasObras() {

         BorderPane MostarObrasVentana = new BorderPane();
        GridPane ventanaCentroMostar = new GridPane();
        VBox vboxControlador = new VBox();
        Label Ordenartop = new Label("\n");
        Label Ordenartopp = new Label("\n");
        Label Ordenartoppp = new Label("\n");
        Label Espacio = new Label("                ");
        Label etiquetaSeleccionartipoObra = new Label("Seleccione el tipo de obra:");
        ToggleGroup group_radioButton = new ToggleGroup();
        RadioButton radioBLibros = new RadioButton("Libros ");
        RadioButton radioBRevistas = new RadioButton("Revistas ");
        RadioButton radioBMemorias = new RadioButton("Memorias ");
        RadioButton radioBTesis = new RadioButton("Tesis ");
        RadioButton radioBPeriodicos = new RadioButton("Periodicos ");
        HBox hboxOrdenRadioBotones = new HBox();
        
        radioBLibros.setToggleGroup(group_radioButton);
        radioBMemorias.setToggleGroup(group_radioButton);
        radioBPeriodicos.setToggleGroup(group_radioButton);
        radioBRevistas.setToggleGroup(group_radioButton);
        radioBTesis.setToggleGroup(group_radioButton);
        
        //Accion Radio botones
        radioBLibros.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(MostrarListalibros());
        });
        radioBMemorias.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(MostrarListaMemorias());
        });
        radioBPeriodicos.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(MostrarListaPeriodicos());
        });
        radioBRevistas.setOnAction((ActionEvent event) -> {
              vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(MostrarListaRevistas());
        });
        radioBTesis.setOnAction((ActionEvent event) -> {
            vboxControlador.getChildren().clear();
            vboxControlador.getChildren().addAll(MostrarListaTesis());
        });
        
        
        hboxOrdenRadioBotones.getChildren().addAll(radioBMemorias,radioBLibros,radioBPeriodicos,radioBRevistas,radioBTesis);
        
        ventanaCentroMostar.add(Ordenartop, 0, 0);
        ventanaCentroMostar.add(etiquetaSeleccionartipoObra, 0, 1);
        ventanaCentroMostar.add(Ordenartoppp, 0, 2);
        ventanaCentroMostar.add(hboxOrdenRadioBotones, 0, 3);
        ventanaCentroMostar.add(Ordenartopp, 0, 4);
        ventanaCentroMostar.add(vboxControlador,0,5);
        
        
         
        MostarObrasVentana.setTop(ventanaCentroMostar);
       ventanaCentroMostar.setAlignment(Pos.CENTER);
        return MostarObrasVentana;

    }
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
        tabla.setMaxSize(400, 200);






        VBox vbox=new VBox();
        vbox.getChildren().addAll(tabla);
        vbox.setMaxSize(500, 600);
        return vbox;
    }
      public ObservableList<Libros> getDatosTabla(){
        ArrayList array=new ArrayList();
      
       Libros temp[]=arregloLibros();
        for(Libros valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Libros> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }  
        public int CantidadRegistros(String tipoArchivo) {//cuenta la cantidad de lineas que tiene el registro
        int cuentaRegistro = 0;
        try {
            BufferedReader br = getBufferedReader(tipoArchivo);
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

    public Libros[] arregloLibros() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Libros elementosLibros[] = new Libros[CantidadRegistros("Libros.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Libros.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo="", fechaIngreso="", Autor="",codigoISBN="", Tema="",subtema="", Estado="";
               

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        Autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        codigoISBN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Tema = st.nextToken();
                    } else if (controlaTokens == 6) {
                        subtema = st.nextToken();
                    } else if (controlaTokens == 7) {
                        Estado = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Libros libros= new Libros(titulo, fechaIngreso, Autor, codigoISBN, Tema, subtema, Estado);
                elementosLibros[indice] = libros;
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

        return elementosLibros;
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
       
       Memorias temp[]=arregloMemorias();
        for(Memorias valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Memorias> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
         public Memorias[] arregloMemorias() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Memorias elementosMemorias[] = new Memorias[CantidadRegistros("Memorias.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Memorias.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo="",fechaIngreso="",Autor="",Resumen="",Abstract="",conferenciaPresentada="",Estado="";
               
               

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                   
                    } else if (controlaTokens == 3) {
                        Autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        Resumen = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Abstract = st.nextToken();
                    } else if (controlaTokens == 6) {
                       conferenciaPresentada= st.nextToken();
                        } else if (controlaTokens == 7) {
                       Estado = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Memorias memorias= new Memorias(titulo, fechaIngreso, Autor, Resumen, Abstract,conferenciaPresentada, Estado);
                elementosMemorias[indice] = memorias;
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

        return elementosMemorias;
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
       
       Periodicos temp[]=arregloPeriodico();
        for(Periodicos valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Periodicos> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
           public Periodicos[] arregloPeriodico() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Periodicos elementosPeriodicos[] = new Periodicos[CantidadRegistros("Periodicos.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Periodicos.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo="",fechaIngreso="",Autor="",Resumen="",CodigoISSN="",Edicion="",Fecha="",Estado="";
               

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        Autor = st.nextToken();
                   
                    } else if (controlaTokens == 4) {
                        CodigoISSN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Edicion = st.nextToken();
                    } else if (controlaTokens == 6) {
                       Fecha = st.nextToken();
                    }else if (controlaTokens == 7) {
                       Estado = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Periodicos periodicos= new Periodicos(titulo,fechaIngreso,Autor,CodigoISSN, Edicion, Fecha, Estado);
                elementosPeriodicos[indice] = periodicos;
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

        return elementosPeriodicos;
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
       
       Revistas temp[]=arregloRevistas();
        for(Revistas valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Revistas> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
            public Revistas[] arregloRevistas() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Revistas elementosRevistas[] = new Revistas[CantidadRegistros("Revistas.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Revistas.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo="",fechaIngreso="",Autor="",codigoISSN="",edicion="",Estado="";
               

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        Autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        codigoISSN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        edicion = st.nextToken();
                   
                    } else if (controlaTokens == 6) {
                       Estado = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Revistas revistas= new Revistas(titulo, fechaIngreso, Autor, codigoISSN, edicion, Estado);
                elementosRevistas[indice] = revistas;
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

        return elementosRevistas;
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
        Resumen.setCellValueFactory(new PropertyValueFactory<>("resumen"));
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
       
       Tesis temp[]=arregloTesis();
        for(Tesis valor:temp)
            array.add(valor);
         
        
        
        ObservableList<Tesis> listaDatos=FXCollections.observableArrayList(array);
         return listaDatos;       
         
    }
           public Tesis[] arregloTesis() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Tesis elementosTesis[] = new Tesis[CantidadRegistros("Tesis.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Tesis.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo="",fechaIngreso="",Autor="",Resumen="",Abstract="",Estado="";
               

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        Autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        Resumen = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Abstract= st.nextToken();
                   
                    } else if (controlaTokens == 6) {
                       Estado = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Tesis tesis= new Tesis(titulo, fechaIngreso, Autor, Resumen, Abstract, Estado);
                elementosTesis[indice] =tesis;
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

        return elementosTesis;
    }
}
