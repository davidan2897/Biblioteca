/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces.Catalogo;

import Constructores.Libros;
import Constructores.Memorias;
import Constructores.Periodicos;
import Constructores.Revistas;
import Constructores.Tesis;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Michelle
 */
public class ArchivosObras {

    
    public void agregarLibros(String titulo, String fechaIngreso, String autor, String codigoISBN, String tema, String subtema, boolean editable) {
        PrintStream ps = getPrintStream("Libros.txt", editable);
        ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISBN + ";" + tema + ";" + subtema);
    }

    public void agregarMemorias(String titulo, String fechaIngreso, String autor, String resumen, String Abstract, String conferecinaPresentada, boolean editable) {
        PrintStream ps = getPrintStream("Memorias.txt", editable);
        ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + resumen + ";" + Abstract + ";" + conferecinaPresentada);
    }

    public void agregarRevistas(String titulo, String fechaIngreso, String autor, String codigoISSN, String edicion, boolean editable) {
        PrintStream ps = getPrintStream("Revistas.txt", editable);
        ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISSN + ";" + ";" + edicion);
    }

    public void agregarPeriodicos(String titulo, String fechaIngreso, String autor, String codigoISSN, String edicion, String fecha, boolean editable) {
        PrintStream ps = getPrintStream("Periodicos.txt", editable);
        ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISSN + ";" + edicion + ";" + fecha);
    }

    public void agregarTesis(String titulo, String fechaIngreso, String autor, String resumen, String Abstract, boolean editable) {
        PrintStream ps = getPrintStream("Tesis.txt", editable);
        ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + resumen + ";" + Abstract);
    }//Fin agregarBibliotecarioArchivo

    //Retorna un string especifico de una linea del archivo
    public String getNombreArchivo(String archivo, int lugarNombre) {
        String nombreArchivo = "";
        int contandor = 0;
        for (int i = 0; i < archivo.length() && contandor != lugarNombre + 1; i++) {
            if (archivo.charAt(i) == ';') {
                contandor++;
            } //            if(contandor==lugarNombre && archivo.charAt(i)!=';')
            else {
                nombreArchivo += archivo.charAt(i);
            }
        }
        return nombreArchivo;
    }//Fin getNombreArchivo

    public BufferedReader getBufferedReader(String nombreArchivo) {
        File archivo = new File(nombreArchivo);
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(archivo);
            InputStreamReader isr = new InputStreamReader(fis);
            br = new BufferedReader(isr);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Problemas con el archivo.");
        }
        return br;
    }//Fin getBufferedReader

    public Libros[] arregloLibros() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Libros elementosLibros[] = new Libros[cuentaLineasArchivo("Libros.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Libros.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo = "", fechaIngreso = "", autor = "", codigoISBN = "", tema = "", subtema = "",Estado="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        codigoISBN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        tema = st.nextToken();
                    } else if (controlaTokens == 6) {
                        subtema = st.nextToken();
                    } else if(controlaTokens == 7) {
                        Estado = st.nextToken();
                    
                        
                    } else {
                        controlaTokens = st.countTokens();
                            
                    }

                    controlaTokens++;
                }//Fin del While 2;
                Libros L = new Libros(titulo, fechaIngreso, autor, codigoISBN, tema, subtema,Estado);
                elementosLibros[indice] = L;
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

    public Memorias[] arregloMemorias() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Memorias elementosMemorias[] = new Memorias[cuentaLineasArchivo("Memorias.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Memorias.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo = "", fechaIngreso = "", autor = "", resumen = "", Abstract = "", conferecinaPresentada = "",Estado="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        resumen = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Abstract = st.nextToken();
                    } else if (controlaTokens == 6) {
                        conferecinaPresentada = st.nextToken();
                   } else if(controlaTokens == 7) {
                        Estado = st.nextToken();
                    
                        
                    } else {
                        controlaTokens = st.countTokens();
                            
                    }
                    controlaTokens++;
                }//Fin del While 2;
                Memorias M = new Memorias(titulo, fechaIngreso, autor, resumen, Abstract, conferecinaPresentada,Estado);
                elementosMemorias[indice] = M;
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

    public Revistas[] arregloRevistas() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Revistas elementosRevistas[] = new Revistas[cuentaLineasArchivo("Revistas.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Revistas.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo = "", fechaIngreso = "", autor = "", codigoISSN = "", edicion = "",Estado ="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        codigoISSN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        edicion = st.nextToken();
                    } else if(controlaTokens == 6) {
                        Estado = st.nextToken();
                    
                        
                    } else {
                        controlaTokens = st.countTokens();
                            
                    }
                    controlaTokens++;
                }//Fin del While 2;
                Revistas R = new Revistas(titulo, fechaIngreso, autor, codigoISSN, edicion,Estado);
                elementosRevistas[indice] = R;
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

    public Periodicos[] arregloPeriodicos() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Periodicos elementosPeriodicos[] = new Periodicos[cuentaLineasArchivo("Periodicos.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Periodicos.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo = "", fechaIngreso = "", autor = "", codigoISSN = "", edicion = "", fecha = "",Estado="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        codigoISSN = st.nextToken();
                    } else if (controlaTokens == 5) {
                        edicion = st.nextToken();
                    } else if (controlaTokens == 6) {
                        fecha = st.nextToken();
                   } else if(controlaTokens == 7) {
                        Estado = st.nextToken();
                    
                        
                    } else {
                        controlaTokens = st.countTokens();
                            
                    }

                    controlaTokens++;
                }//Fin del While 2;
                Periodicos P = new Periodicos(titulo, fechaIngreso, autor, codigoISSN, edicion, fecha,Estado);
                elementosPeriodicos[indice] = P;
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

    public Tesis[] arregloTesis() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Tesis elementosTesis[] = new Tesis[cuentaLineasArchivo("Tesis.txt")];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Tesis.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String titulo = "", fechaIngreso = "", autor = "", resumen = "", Abstract = "",Estado="";

                StringTokenizer st = new StringTokenizer(registro, ";");

                while (st.hasMoreTokens()) {

                    if (controlaTokens == 1) {
                        titulo = st.nextToken();
                    } else if (controlaTokens == 2) {
                        fechaIngreso = st.nextToken();
                    } else if (controlaTokens == 3) {
                        autor = st.nextToken();
                    } else if (controlaTokens == 4) {
                        resumen = st.nextToken();
                    } else if (controlaTokens == 5) {
                        Abstract = st.nextToken();
                   } else if(controlaTokens == 6) {
                        Estado = st.nextToken();
                    
                        
                    } else {
                        controlaTokens = st.countTokens();
                            
                    }

                    controlaTokens++;
                }//Fin del While 2;
                Tesis T = new Tesis(titulo, fechaIngreso, autor, resumen, Abstract,Estado);
                elementosTesis[indice] = T;
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

    //cuenta la cantidad de lineas que tiene el registro
    public int cuentaLineasArchivo(String archivo) {
        int contador = 0;
        BufferedReader br = getBufferedReader(archivo);
        try {
            String registroActual = br.readLine();

            while (registroActual != null) {
                contador++;
                registroActual = br.readLine();

            }//Fin while 
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
        return contador;
    }//Fin cuentaLineasArchivo

//         public int CantidadRegistrosUsuarios() {//cuenta la cantidad de lineas que tiene el registro
//        int cuentaRegistro = 0;
//        try {
//            BufferedReader br = getBufferedReader("Usuarios.txt");
//            String registro = br.readLine();
//            while (registro != null) {
//                cuentaRegistro++;
//                registro = br.readLine();
//            }
//        } catch (IOException ioe) {
//            JOptionPane.showMessageDialog(null, "error");
//        }
//        return cuentaRegistro;
//    } 
//    
    //Retorna un arreglo con los string del archivo
    public String[] getArregloArchivo(String nombreArchivo) {
        String arregloArchivo[] = new String[cuentaLineasArchivo(nombreArchivo)];
        int indice = 0;
        BufferedReader br = getBufferedReader(nombreArchivo);
        try {
            String registroActual = br.readLine();

            while (registroActual != null) {
                arregloArchivo[indice] = registroActual;
                indice++;
                registroActual = br.readLine();

            }//Fin while 
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
        return arregloArchivo;
    }//Fin getArregloArchivo

    //Verifica si exite cliente, vehiculo y reservacion
    public boolean existeObra(String identificador, String archivo) {
        boolean existe = false;
        BufferedReader br = getBufferedReader(archivo);
        try {
            String registroActual = br.readLine();

            while (registroActual != null && !existe) {
                if (getNombreArchivo(registroActual, 0).equalsIgnoreCase(identificador)) {
                    return true;
////                    registroActual = null;
                }
                registroActual = br.readLine();
            }
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Error en el archivo");
        }
        return false;
    }//Fin existeClienteOVehiculoOReservacion
    //Adiciones sobre archivos
    //Verifica si exite usuario

    //Retorna un arreglo con cada seccion de una linea del archivo
    public String[] getDatosEspecificos(String archivo, String identificador) {
        int tamanoArreglo = 0;
        if (archivo.equals("Libros.txt")) {
            tamanoArreglo = 6;
        } else if (archivo.equals("Memorias.txt")) {
            tamanoArreglo = 6;
        } else if (archivo.equals("Revistas.txt")) {
            tamanoArreglo = 5;
        } else if (archivo.equals("Periodicos.txt")) {
            tamanoArreglo = 6;
        } else {
            tamanoArreglo = 5;
        }
        String datos[] = new String[tamanoArreglo];
        String registroActual = getRegistroActual(archivo, identificador);
        String temp = "";
        int i = 0, contador = 0;
        while (i < registroActual.length()) {
            if (registroActual.charAt(i) != ';') {
                temp += registroActual.charAt(i);
            } else {
                datos[contador++] = temp;
                temp = "";
            }
            i++;
        }
        datos[contador] = temp;
        return datos;
    }//Fin getDatosEspecificos

    public PrintStream getPrintStream(String nombreArchivo, boolean editable) {

        File archivo = new File(nombreArchivo);
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream(archivo, editable);
            ps = new PrintStream(fos);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Problemas con el archivo.");
        }
        return ps;
    }//Fin getPrintStream

    public String getRegistroActual(String archivo, String identificador) {
        int indice = 0;
        BufferedReader br = getBufferedReader(archivo);
        String registroActual = "";
        try {
            registroActual = br.readLine();
            while (!getNombreArchivo(registroActual, 0).equals(identificador)) {
                registroActual = br.readLine();
            }//Fin while 
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Problemas con el archivo");
        }
        return registroActual;
    }//Fin getRegistroActual

    //Actualiza clientes
    public void actualizarLibro(String titulo, String fechaIngreso, String autor, String codigoISBN, String tema, String subtema) {
        String[] arregloArchivo = getArregloArchivo("Libros.txt");

        PrintStream ps = getPrintStream("Libros.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(titulo)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISBN + ";" + tema + ";" + subtema);
            }
        }
    }//Fin 

    public void actualizarMemoria(String titulo, String fechaIngreso, String autor, String resumen, String Abstract, String conferecinaPresentada) {
        String[] arregloArchivo = getArregloArchivo("Memorias.txt");

        PrintStream ps = getPrintStream("Memorias.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(titulo)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + resumen + ";" + Abstract + ";" + conferecinaPresentada);
            }
        }
    }//Fin

    public void actualizarRevista(String titulo, String fechaIngreso, String autor, String codigoISSN, String edicion) {
        String[] arregloArchivo = getArregloArchivo("Revistas.txt");

        PrintStream ps = getPrintStream("Revistas.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(titulo)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISSN + ";" + edicion);
            }
        }
    }//Fin

    public void actualizarPeriodicos(String titulo, String fechaIngreso, String autor, String codigoISSN, String edicion, String fecha) {
        String[] arregloArchivo = getArregloArchivo("Periodicos.txt");

        PrintStream ps = getPrintStream("Periodicos.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(titulo)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + codigoISSN + ";" + edicion + ";" + fecha);
            }
        }
    }//Fin

    public void actualizarTesis(String titulo, String fechaIngreso, String autor, String resumen, String Abstract) {
        String[] arregloArchivo = getArregloArchivo("Tesis.txt");

        PrintStream ps = getPrintStream("Tesis.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(titulo)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(titulo + ";" + fechaIngreso + ";" + autor + ";" + resumen + ";" + Abstract);
            }
        }
    }//Fin

}
