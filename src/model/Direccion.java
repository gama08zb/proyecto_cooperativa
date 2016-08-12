package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Direccion {
	private IntegerProperty codigoDireccion;
	private IntegerProperty codigoColonia;
	private StringProperty descripcionDireccion;
	
	
	public Direccion(int codigoDireccion, int codigoColonia, String descripcionDireccion){
		this.codigoDireccion= new SimpleIntegerProperty(codigoDireccion);
		this.codigoColonia= new SimpleIntegerProperty(codigoColonia);
		this.descripcionDireccion= new SimpleStringProperty(descripcionDireccion);		
	}
	public Direccion( int codigoColonia, String descripcionDireccion){
		this.codigoColonia= new SimpleIntegerProperty(codigoColonia);
		this.descripcionDireccion= new SimpleStringProperty(descripcionDireccion);		
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
	
	public IntegerProperty codigoColoniaProperty() {
		return codigoColonia;
	}

	public int getCodigoColonia() {
		return codigoColonia.get();
	}
	
	public void setCodigoColonia(int codigoColonia) {
		this.codigoColonia= new SimpleIntegerProperty(codigoColonia);
	}
	public StringProperty descripcionDireccionProperty() {
		return descripcionDireccion;
	}
	
	public String getDescripcionDireccion() {
		return descripcionDireccion.get();
	}
	
	public void setDescripcionDireccion(String descripcionDireccion) {
		this.descripcionDireccion= new SimpleStringProperty(descripcionDireccion);
	}
}
