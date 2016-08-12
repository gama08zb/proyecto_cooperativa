package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {
	private StringProperty codigoPersona;
	private IntegerProperty codigoEstadoCivil;
	private IntegerProperty codigoDireccion;
	private StringProperty numeroIdentidad;
	private StringProperty nombres;
	private StringProperty apellidos;
	private StringProperty telefono;
	private StringProperty celular;
	private StringProperty correoElectronico;
	private StringProperty genero;
	private Date fechaNacimiento;
	
	
	public Persona(	String codigoPersona,int codigoEstadoCivil,int codigoDireccion,
					String numeroIdentidad,String nombres,
					String apellidos, String telefono,String celular,
					String correoElectronico, String genero, Date fechaNacimiento){
		this.codigoPersona = new SimpleStringProperty(codigoPersona);
		this.codigoEstadoCivil= new SimpleIntegerProperty(codigoEstadoCivil);
		this.codigoDireccion=new SimpleIntegerProperty(codigoDireccion);
		this.numeroIdentidad= new SimpleStringProperty(numeroIdentidad);
		this.nombres= new SimpleStringProperty(nombres);
		this.apellidos= new SimpleStringProperty(apellidos);
		this.telefono= new SimpleStringProperty(telefono);
		this.celular= new SimpleStringProperty(celular);
		this.correoElectronico= new SimpleStringProperty(correoElectronico);
		this.genero= new SimpleStringProperty(genero);
		this.fechaNacimiento= fechaNacimiento;
	}
	
	public Persona(	int codigoEstadoCivil,int codigoDireccion,
			String numeroIdentidad,String nombres,
			String apellidos, String telefono,String celular,
			String correoElectronico, String genero, Date fechaNacimiento){
		this.codigoEstadoCivil= new SimpleIntegerProperty(codigoEstadoCivil);
		this.codigoDireccion=new SimpleIntegerProperty(codigoDireccion);
		this.numeroIdentidad= new SimpleStringProperty(numeroIdentidad);
		this.nombres= new SimpleStringProperty(nombres);
		this.apellidos= new SimpleStringProperty(apellidos);
		this.telefono= new SimpleStringProperty(telefono);
		this.celular= new SimpleStringProperty(celular);
		this.correoElectronico= new SimpleStringProperty(correoElectronico);
		this.genero= new SimpleStringProperty(genero);
		this.fechaNacimiento= fechaNacimiento;
}
	
	public StringProperty codigoPersonaProperty() {
		return codigoPersona;
	}

	public String getCodigoPersona() {
		return codigoPersona.get();
	}
	
	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona= new SimpleStringProperty(codigoPersona);
	}
	
	public IntegerProperty codigoEstadoCivilProperty() {
		return codigoEstadoCivil;
	}

	public int getEstadoCivil() {
		return codigoEstadoCivil.get();
	}
	
	public void setCodigoEstadoCivil(int codigoEstadoCivil) {
		this.codigoEstadoCivil= new SimpleIntegerProperty(codigoEstadoCivil);
	}
	
	public IntegerProperty codigoDireccionProperty() {
		return codigoDireccion;
	}

	public int getCodigoDireccion() {
		return codigoDireccion.get();
	}
	
	public void setCodigoDireccion(int codigoDireccion) {
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
	}
	
	public StringProperty numeroIdentidadProperty() {
		return numeroIdentidad;
	}
	
	public String getNumeroIdentidad() {
		return numeroIdentidad.get();
	}
	
	public void setNumeroIdentidad(String numeroIdentidad) {
		this.numeroIdentidad= new SimpleStringProperty(numeroIdentidad);
	}
	
	public StringProperty nombresProperty() {
		return nombres;
	}
	
	public String getNombres() {
		return nombres.get();
	}
	
	public void setNombres(String nombres) {
		this.nombres= new SimpleStringProperty(nombres);
	}
	
	public StringProperty apellidosProperty() {
		return apellidos;
	}
	
	public String getApellidos() {
		return apellidos.get();
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos= new SimpleStringProperty(apellidos);
	}
	
	public StringProperty telefonoProperty() {
		return telefono;
	}
	
	public String getTelefono() {
		return telefono.get();
	}
	
	public void setTelefono(String telefono) {
		this.telefono= new SimpleStringProperty(telefono);
	}
	
	public StringProperty celularProperty() {
		return celular;
	}
	
	public String getCelular() {
		return celular.get();
	}
	
	public void setCelular(String celular) {
		this.celular= new SimpleStringProperty(celular);
	}
	public StringProperty correoElectronicoProperty() {
		return correoElectronico;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico.get();
	}
	
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico= new SimpleStringProperty(correoElectronico);
	}
	
	public StringProperty generoProperty() {
		return genero;
	}
	
	public String getGenero() {
		return genero.get();
	}
	
	public void setGenero(String genero) {
		this.genero= new SimpleStringProperty(genero);
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
