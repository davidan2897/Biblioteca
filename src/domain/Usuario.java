
package domain;


import domain.Usuarios;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import javax.swing.JOptionPane;


/************************************************************/
/**
 * 
 */
public class Usuario extends Usuarios
 {

    public Usuario(String unicoNombre, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion,String tipoUsuario) {
        super(unicoNombre, contraseña, nombreCompleto, tipoIdentificacion, identificacion,tipoUsuario);
    }
	/**
	 * 
	 */
	public void ListaObrasPrestadas() {
	}

	@Override
	public boolean Borrar() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void Agregar(Usuario usuario) {
		// TODO Auto-generated method stub
	 PrintStream ps = getPrintStream("Usuarios.txt");

        ps.println(usuario.getUnicoNombre() + ";" + usuario.getContraseña()+ ";" + usuario.getNombreCompleto()+ ";" + usuario.getTipoID() + ";" + usuario.getIdentificacion()+";"+usuario.gettipoUsuario());
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

	@Override
	public boolean Buscar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Mostrar() {
		// TODO Auto-generated method stub
		
	}

    @Override
    public void Agregar(Bibliotecarios bi, Autores au) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
};
