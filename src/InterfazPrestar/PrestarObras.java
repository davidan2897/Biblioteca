package InterfazPrestar;

import Interfaces.Catalogo.UtilidadesGestionar;
import Interfaces.Usuarios.GestionarBibliotecarios;
import Constructores.Bibliotecarios;
import Constructores.Prestar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.StringTokenizer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author david
 */
public class PrestarObras {

    TextField texfieldTituloObta;
    GestionarBibliotecarios gestionarBibliotecario = new GestionarBibliotecarios();
    Prestar prestar;
    private String fechaPrestamo;
    private String fechaRetorno;
    private String usuarioUnico;
    private String tituloObra;
    TextField textfUsuario;
    Button btnAgregar;
    DatePicker datepickerFechaPrestamo;
    DatePicker datepickerFechaRetorno;
    String tipoObraModificar;
    ComboBox<String> comboTipoObta;
    UtilidadesGestionar utilGestionar = new UtilidadesGestionar();

    public BorderPane prestarObras() {

        BorderPane PrestarVentana = new BorderPane();
        GridPane ventanaCentroPrestar = new GridPane();
        HBox OrdenBotones = new HBox();
        Label Ordenartop = new Label("\n\n\n\n\n\n");
        Label Espacio = new Label("                ");
        Label IngreseUsuario = new Label("Ingrese el nombre de usuario que desea asignar la obra:");
        textfUsuario = new TextField();
        comboTipoObta = new ComboBox<>();
        comboTipoObta.getItems().addAll("Libros", "Revistas", "Tesis", "Memorias", "Periodicos");
        Label etiquetatipoObra = new Label("Tipo Obra:");
        Label etiquetaTitulo = new Label("Titulo de la obra:");
        Label etiquetaFechaPrestamo = new Label("Fecha Prestamo");
        Label etiquetaFechaRetorno = new Label("Fecha Retorno");
        texfieldTituloObta = new TextField();
        datepickerFechaPrestamo = new DatePicker();
        datepickerFechaRetorno = new DatePicker();
        datepickerFechaPrestamo.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datepickerFechaPrestamo.getValue();
                int dia = date.getDayOfMonth();
                int mes = date.getMonthValue();
                int año = date.getYear();
                fechaPrestamo = dia + "/" + mes + "/" + año;
            }
        });
        datepickerFechaRetorno.setOnAction(new EventHandler() {
            public void handle(Event t) {
                LocalDate date = datepickerFechaRetorno.getValue();
                int dia = date.getDayOfMonth();
                int mes = date.getMonthValue();
                int año = date.getYear();
                fechaRetorno = dia + "/" + mes + "/" + año;
            }
        });

        Button btnIngresar = new Button("Ingresar");
        Button btnCancelar = new Button("Cancelar");
        
        
        btnIngresar.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                usuarioUnico = textfUsuario.getText();
                tituloObra = texfieldTituloObta.getText();
                String tipoObra = comboTipoObta.getValue().toString();
                prestar = new Prestar(fechaPrestamo, fechaRetorno, usuarioUnico, tituloObra, tipoObra);
                tipoObraModificar = tipoObra;
                tipoObraModificar += ".txt";
                
                
               
                if (verificarUsuariosDisponible(gestionarBibliotecario.arregloUsuarios(), usuarioUnico)) {
                    if(utilGestionar.buscar(tituloObra, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(tipoObraModificar), 
                    tipoObraModificar))==true){
                     if(verficaEstadoObra(utilGestionar.getArreglo(utilGestionar.CantidadRegistros(tipoObraModificar),tipoObraModificar), tipoObraModificar,tituloObra)==true){   
                    Agregar(prestar);
                   
                    ModificarEstadoobra(utilGestionar.getArreglo(utilGestionar.CantidadRegistros(tipoObraModificar),
                    tipoObraModificar), tipoObraModificar, tituloObra);
                        Limpiar();
                    JOptionPane.showMessageDialog(null, "Obra prestada a "+usuarioUnico);
                }else {
                    JOptionPane.showMessageDialog(null, "Obra se encuetra prestada");
                }
                }else {
                    JOptionPane.showMessageDialog(null, "Obra no esta registrado");
                }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario no esta registrado");
                }
                Limpiar();

            }
        });

        OrdenBotones.getChildren().addAll(btnIngresar, btnCancelar);

        ventanaCentroPrestar.add(IngreseUsuario, 1, 0);
        ventanaCentroPrestar.add(textfUsuario, 2, 0);
        ventanaCentroPrestar.add(etiquetatipoObra, 1, 1);
        ventanaCentroPrestar.add(comboTipoObta, 2, 1);
        ventanaCentroPrestar.add(etiquetaTitulo, 1, 2);
        ventanaCentroPrestar.add(texfieldTituloObta, 2, 2);
        ventanaCentroPrestar.add(etiquetaFechaPrestamo, 1, 3);
        ventanaCentroPrestar.add(datepickerFechaPrestamo, 2, 3);
        ventanaCentroPrestar.add(etiquetaFechaRetorno, 1, 4);
        ventanaCentroPrestar.add(datepickerFechaRetorno, 2, 4);
        ventanaCentroPrestar.add(btnIngresar, 2, 6);

        PrestarVentana.setRight(Espacio);
        PrestarVentana.setTop(Ordenartop);
        PrestarVentana.setCenter(ventanaCentroPrestar);
        ventanaCentroPrestar.setAlignment(Pos.CENTER);

        return PrestarVentana;

    }

    public void Limpiar() {
        texfieldTituloObta.setText("");
        textfUsuario.setText("");
        comboTipoObta.setValue("");
        
    }

    public PrintStream getPrintStream(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(archivo, true);
            ps = new PrintStream(fos);

        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "error");

        }
        return ps;
    }

    public void Agregar(Prestar prestar) {

        PrintStream ps = getPrintStream("ObrasPrestadas.txt");

        ps.println(prestar.getFechaPrestamo() + ";" + prestar.getFechaRetorno() + ";" + prestar.getNombreUnico() + ";" + prestar.getNombreObra() + ";" + prestar.getTipoObra());
    }

    public boolean verificarUsuariosDisponible(Bibliotecarios[] B, String nombreunico) {
        boolean encontrado = false;

        for (int i = 0; i < B.length; i++) {

            if (nombreunico.equals(B[i].getUnicoNombre())) {
                encontrado = true;
            
                break;
            }

        }

        return encontrado;

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

    public Prestar[] arregloObrasPrestadas() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Prestar elementosUsuarios[] = new Prestar[CantidadRegistrosUsuarios()];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("ObrasPrestadas.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String fechaPrestamo = "", fechaRetorno = "", nombreUnico = "", nombreObra = "", tipoObra = "";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        fechaPrestamo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaRetorno = st.nextToken();
                    } else if (controlaTokens == 3) {
                        nombreUnico = st.nextToken();
                    } else if (controlaTokens == 4) {
                        nombreObra = st.nextToken();
                    } else if (controlaTokens == 5) {
                        tipoObra = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;

                Prestar Prestar = new Prestar(fechaPrestamo, fechaRetorno, nombreUnico, nombreObra, tipoObra);
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
    public void ModificarEstadoobra (String a[],String nombreArchivo,String obra){
        String Obras ="",Estado="",Archivonombreobra="",fechaIngreso ="",Autor = "",codigoISBN = "",
                Tema = "",subtema="";
       
          if(nombreArchivo.equalsIgnoreCase("Revistas.txt")|| nombreArchivo.equalsIgnoreCase("Tesis.txt")){
    for(int i =0;i<a.length;i++){
            Obras = a[i];
            StringTokenizer sT = new StringTokenizer(Obras, ";");
            Archivonombreobra = sT.nextToken();
            fechaIngreso = sT.nextToken();
            Autor = sT.nextToken();
            codigoISBN = sT.nextToken();
            Tema = sT.nextToken();
            Estado = "Prestado";
        if(obra.equalsIgnoreCase(Archivonombreobra)){
          
         PrintStream ps = getPrintStream(nombreArchivo);
         utilGestionar.eliminar(Archivonombreobra, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo), nombreArchivo);
         ps.println(Archivonombreobra+";"+fechaIngreso+";"+Autor+";"+codigoISBN+";"+Tema+Estado);
        }
        }//fin for1
        }//fin if verifica archivo
          else{
        for(int i =0;i<a.length;i++){
            Obras = a[i];
            StringTokenizer sT = new StringTokenizer(Obras, ";");
            Archivonombreobra = sT.nextToken();
            fechaIngreso = sT.nextToken();
            Autor = sT.nextToken();
            codigoISBN = sT.nextToken();
            Tema = sT.nextToken();
            subtema = sT.nextToken();
            Estado = "Prestado";
        if(obra.equalsIgnoreCase(Archivonombreobra)){
          
         PrintStream ps = getPrintStream(nombreArchivo);
         utilGestionar.eliminar(Archivonombreobra, utilGestionar.getArreglo(utilGestionar.CantidadRegistros(nombreArchivo), nombreArchivo), nombreArchivo);
         ps.println(Archivonombreobra+";"+fechaIngreso+";"+Autor+";"+codigoISBN+";"+Tema+";"+subtema+";"+Estado);
        }
        }//fin for2
        }//fin else
    

    }//fin mpdificarObra
    //Metodo que verifica el estado de una obra
    
    public boolean verficaEstadoObra (String a[], String nombreArchivo,String obra){
        String Obras ="",Estado="",Archivonombreobra="",fechaIngreso ="",Autor = "",codigoISBN = "",
                Tema = "",subtema="";
        boolean state=false;
  
          if(nombreArchivo.equalsIgnoreCase("Revistas.txt")|| nombreArchivo.equalsIgnoreCase("Tesis.txt")){
    for(int i =0;i<a.length;i++){
            Obras = a[i];
            StringTokenizer sT = new StringTokenizer(Obras, ";");
            Archivonombreobra = sT.nextToken();
            fechaIngreso = sT.nextToken();
            Autor = sT.nextToken();
            codigoISBN = sT.nextToken();
            Tema = sT.nextToken();
            Estado = sT.nextToken();
             if(obra.equalsIgnoreCase(Archivonombreobra) && Estado.equalsIgnoreCase("Disponible"))
            state =true;
    }//fin for1
          }//fin if es revista o tesis
           else{
        for(int i =0;i<a.length;i++){
            Obras = a[i];
            StringTokenizer sT = new StringTokenizer(Obras, ";");
            Archivonombreobra = sT.nextToken();
            fechaIngreso = sT.nextToken();
            Autor = sT.nextToken();
            codigoISBN = sT.nextToken();
            Tema = sT.nextToken();
            subtema = sT.nextToken();
            Estado = sT.nextToken();
            if(obra.equalsIgnoreCase(Archivonombreobra) && Estado.equalsIgnoreCase("Disponible")){
            state =true;
                   }//fin if
        }//fin for
          
          
       
}

          
        return state;
    }//fin verificaEstadoObra
}//fin clase