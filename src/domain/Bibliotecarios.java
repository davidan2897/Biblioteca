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
public class Bibliotecarios extends Usuarios
 {
    
    @Override
    
    public String getNombreCompleto() {
        return super.getNombreCompleto(); //To change body of generated methods, choose Tools | Templates.
    }

    public Bibliotecarios(String unicoNombre, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion,String tipoUsuario) {
        super(unicoNombre, contraseña, nombreCompleto, tipoIdentificacion, identificacion,tipoUsuario);
    }

    
    
    
	@Override
	public boolean Borrar() {
		// TODO Auto-generated method stub
		return false;
	}

	public void Agregar(Bibliotecarios bi) {
//		// TODO Auto-generated method stub
       
       PrintStream ps = getPrintStream("Usuarios.txt");

        ps.println(bi.getUnicoNombre() + ";" + bi.getContraseña()+ ";" + bi.getNombreCompleto()+ ";" + bi.getTipoID() + ";" + bi.getIdentificacion()+";"+bi.gettipoUsuario());
	
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
         

    public void Agregar(Bibliotecarios bi, Autores au) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
    
};
