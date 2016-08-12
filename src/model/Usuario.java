
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario{
	private IntegerProperty codigoUsuario;
	private StringProperty nombreUsuario;
	private StringProperty contrasena;
	private IntegerProperty tipoUsuario;
	private StringProperty codigoEmpleado;
	public Usuario(int codigoUsuario, String nombreUsuario, String contrasena, 
int tipoUsuario) { 
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
		this.contrasena = new SimpleStringProperty(contrasena);
		this.tipoUsuario = new SimpleIntegerProperty(tipoUsuario);
	}
	
	public Usuario(String nombreUsuario, String contrasena) { 
					this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
					this.contrasena = new SimpleStringProperty(contrasena);
				}

	//Metodos atributo: codigoUsuario
	public int getCodigoUsuario() {
		return codigoUsuario.get();
	}
	public void setCodigoUsuario(int codigoUsuario) {
		this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	}
	public IntegerProperty CodigoUsuarioProperty() {
		return codigoUsuario;
	}
	//Metodos atributo: nombreUsuario
	public String getNombreUsuario() {
		return nombreUsuario.get();
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	}
	public StringProperty NombreUsuarioProperty() {
		return nombreUsuario;
	}
	//Metodos atributo: contrasena
	public String getCodigoEmpleado() {
		return codigoEmpleado.get();
	}
	public void setCodigoEmpleado(String codigoEmpleado) {
		this.codigoEmpleado = new SimpleStringProperty(codigoEmpleado);
	}
	public StringProperty codigoEmpleadoProperty() {
		return codigoEmpleado;
	}
	//Metodos atributo: tipoUsuario
	public int getTipoUsuario() {
		return tipoUsuario.get();
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = new SimpleIntegerProperty(tipoUsuario);
	}
	public IntegerProperty TipoUsuarioProperty() {
		return tipoUsuario;
	}
	//Metodos atributo: CODIGO EMPLEADO
		public String getContrasena() {
			return contrasena.get();
		}
		public void setContrasena(String contrasena) {
			this.contrasena = new SimpleStringProperty(contrasena);
		}
		public StringProperty ContrasenaProperty() {
			return contrasena;
		}
	public boolean autenticar(Connection conexion){
		try {
			PreparedStatement instruccionLogin 
        	= conexion.prepareStatement(
        			"SELECT COUNT(*) AS CANTIDAD "+
            		"FROM TBL_USUARIOS "+
            		"WHERE USUARIO = ? "+ 
            		"AND PASSWORD = ?");
        
        instruccionLogin.setString(1, nombreUsuario.get());
        instruccionLogin.setString(2, Utilidades.encriptarContrasena(contrasena.get()));
        ResultSet resultadoLogin = instruccionLogin.executeQuery();
        resultadoLogin.next();
        int valido = resultadoLogin.getInt("CANTIDAD");
        
        if (valido==1){
        	instruccionLogin 
        	= conexion.prepareStatement(
        			"SELECT ID_TIPO_USUARIO, ID_EMPLEADO "+
            		"FROM TBL_USUARIOS "+
            		"WHERE USUARIO = ? "+ 
            		"AND PASSWORD = ?");
        instruccionLogin.setString(1, nombreUsuario.get());
        instruccionLogin.setString(2, Utilidades.encriptarContrasena(contrasena.get()));
        resultadoLogin = instruccionLogin.executeQuery();
        resultadoLogin.next();
        tipoUsuario= new SimpleIntegerProperty(resultadoLogin.getInt("ID_TIPO_USUARIO")); 
        codigoEmpleado= new SimpleStringProperty(resultadoLogin.getString("ID_EMPLEADO"));
        conexion.close();
        return true;
        }
        conexion.close();
    }catch(Exception e){
    	e.printStackTrace();
    }
	return false;
	}
}
