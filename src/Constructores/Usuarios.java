package Constructores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;

/************************************************************/
/**
 * 
 */
public abstract class Usuarios {
    	protected Autores autor; 
    protected Bibliotecarios bibliotecario;
    protected Usuario usuario;
    
    public Usuarios(String unicoNombre, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion,String tipoUsuario) {
    	this.unicoNombre = unicoNombre;
        this.contraseña = contraseña;
        this.nombreCompleto=nombreCompleto;
        this.tipoID=tipoIdentificacion;
        this.Identificacion= identificacion;
    	this.tipoUsuario=tipoUsuario;
    	
    }

    public String getUnicoNombre() {
        return unicoNombre;
    }

    public void setUnicoNombre(String unicoNombre) {
        this.unicoNombre = unicoNombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoID() {
        return tipoID;
    }

    public void setTipoID(String tipoID) {
        this.tipoID = tipoID;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }
    public String gettipoUsuario() {
        return tipoUsuario;
    }

    public void settipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
	/**
	 * 
	 */
	private String unicoNombre;
	/**
	 * 
	 */
	private String contraseña;
	/**
	 * 
	 */
	private String nombreCompleto;
	/**
	 * 
	 */
	private String tipoID;
	/**
	 * 
	 */
	private String Identificacion;

	/**
	 * 
	 * @return 
	 */
        private String tipoUsuario;

	/**
	 * 
	 * @return 
	 */
	public abstract boolean Borrar();

	/**
	 * 
	 */
	public abstract void Agregar(Bibliotecarios bi,Autores au);

	/**
	 * 
	 * @return 
	 */
	public abstract boolean Buscar();

	/**
	 * 
	 */
	public void Modificar() {
	}

	/**
	 * 
	 */
	public abstract void Mostrar();
        
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
};
