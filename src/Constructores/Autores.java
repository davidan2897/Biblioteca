//// --------------------------------------------------------
// Code generated by Papyrus Java
// --------------------------------------------------------

package Constructores;


import java.io.PrintStream;


/************************************************************/
/**
 * 
 */
public class Autores extends Usuarios
 {

    public Autores(String unicoNombre, String contraseña, String nombreCompleto, String tipoIdentificacion, String identificacion,String tipoUsuario) {
//        
          super(unicoNombre, contraseña, nombreCompleto, tipoIdentificacion, identificacion,tipoUsuario);
    }

	/**
	 * 
	 */
	public void ListaObrasEscritas() {
	}

	@Override
	public boolean Borrar() {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void Agregar(Autores au) {
		   PrintStream ps = getPrintStream("Usuarios.txt");

        ps.println(au.getUnicoNombre() + ";" + au.getContraseña()+ ";" + au.getNombreCompleto()+ ";" + au.getTipoID() + ";" + au.getIdentificacion()+";"+au.gettipoUsuario());
	
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
