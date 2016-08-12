package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Empresa {
	private IntegerProperty codigoEmpresa;
	private IntegerProperty codigoDireccion;
	private StringProperty nombreEmpresa;
	private StringProperty telefono;
	
	
	public Empresa(int codigoEmpresa, String nombreEmpresa){
		this.codigoEmpresa= new SimpleIntegerProperty(codigoEmpresa);
		this.nombreEmpresa= new SimpleStringProperty(nombreEmpresa);		
	}
	
	public Empresa(int codigoEmpresa, int codigoDireccion, String nombreEmpresa, String telefono){
		this.codigoEmpresa= new SimpleIntegerProperty(codigoEmpresa);
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
		this.nombreEmpresa= new SimpleStringProperty(nombreEmpresa);
		this.telefono= new SimpleStringProperty(telefono);
	}
	
	public Empresa( int codigoDireccion, String nombreEmpresa, String telefono){
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
		this.nombreEmpresa= new SimpleStringProperty(nombreEmpresa);
		this.telefono= new SimpleStringProperty(telefono);
	}
	public IntegerProperty codigoEmpresaProperty() {
		return codigoEmpresa;
	}

	public int getCodigoEmpresa() {
		return codigoEmpresa.get();
	}
	
	public void setCodigoEmpresa(int codigoEmpresa) {
		this.codigoEmpresa= new SimpleIntegerProperty(codigoEmpresa);
	}

	public StringProperty nombreEmpresaProperty() {
		return nombreEmpresa;
	}
	
	public String getNombreEmpresa() {
		return nombreEmpresa.get();
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa= new SimpleStringProperty(nombreEmpresa);
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
	
	public StringProperty telefonoProperty() {
		return telefono;
	}
	
	public String getTelefono() {
		return telefono.get();
	}
	
	public void setTelefono(String telefono) {
		this.telefono= new SimpleStringProperty(telefono);
	}
	
	@Override
	public String toString() {
		return nombreEmpresa.get();
	}	
}
