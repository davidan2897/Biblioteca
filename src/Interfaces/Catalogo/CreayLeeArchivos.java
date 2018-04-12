
package Interfaces.Catalogo;

import Constructores.Bibliotecarios;
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

public class CreayLeeArchivos {
  
    //Agrega usuario a archivo
    public void agregarUsuario(String unicoNombre, String nombre, String contraseña, String identificacion, String tipoIdentificacion, boolean editable) {
        PrintStream ps = getPrintStream("Usuarios.txt", editable);
        ps.println(unicoNombre + ";" + nombre + ";" + contraseña + ";" + tipoIdentificacion + ";" + identificacion + ";");
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

    public Bibliotecarios[] arregloUsuarios() {//obtiene lo que tiene el archivo y lo pasa a un arreglo 
        Bibliotecarios elementosUsuarios[] = new Bibliotecarios[CantidadRegistrosUsuarios()];
        int indice = 0;
        try {
            BufferedReader br = getBufferedReader("Usuarios.txt");
            String registro = br.readLine();
            while (registro != null) {

                int controlaTokens = 1;
                String unicoNombre = "", contraseña = "", nombreCompleto = "", tipoIdentificacion = "", identificacion = "", tipoUsuario = "";

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
                    } else if (controlaTokens == 6) {
                        tipoUsuario = st.nextToken();
                    } else {
                        controlaTokens = st.countTokens();
                    }

                    controlaTokens++;
                }//Fin del While 2;
                Bibliotecarios B = new Bibliotecarios(unicoNombre, contraseña, nombreCompleto, tipoIdentificacion, identificacion, tipoUsuario);
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

    //Verifica si exite usuario
    public boolean existeUsuario(String identificador, String archivo) {
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
    }//Fin existe
  

    //Retorna un arreglo con cada seccion de una linea del archivo
    public String[] getDatosEspecificos(String archivo, String identificador) {
        int tamanoArreglo = 0;
        if (archivo.equals("Usuarios.txt")) {
            tamanoArreglo = 6;
        } else {
            tamanoArreglo = 8;
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

    //Actualiza usuarios
    public void actualizarUsuario(String identificacion, String nombreUnico, String nombreCompleto, String contraseña, String tipoUsuario, String tipoIdentificacon) {
        String[] arregloArchivo = getArregloArchivo("Usuarios.txt");

        PrintStream ps = getPrintStream("Usuarios.txt", false);
        for (int i = 0; i < arregloArchivo.length; i++) {

            if (!getNombreArchivo(arregloArchivo[i], 0).equals(identificacion)) {
                ps.println(arregloArchivo[i]);
            } else {
                ps.println(identificacion + ";" + nombreUnico + ";" + nombreCompleto + ";" + contraseña + ";" + tipoUsuario + ";" + tipoIdentificacon);
            }
        }
    }//Fin 
    

 
    
    
}
