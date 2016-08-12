package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Municipio {
	private IntegerProperty codigoMunicipio;
	private StringProperty nombreMunicipio;
	private IntegerProperty codigoEstado;
	
	public Municipio(int codigoMunicipio, String nombreMunicipio){
		this.codigoMunicipio= new SimpleIntegerProperty(codigoMunicipio);
		this.nombreMunicipio= new SimpleStringProperty(nombreMunicipio);		
	}
	
	public Municipio(int codigoMunicipio,int codigoEstado, String nombreMunicipio){
		this.codigoMunicipio= new SimpleIntegerProperty(codigoMunicipio);
		this.nombreMunicipio= new SimpleStringProperty(nombreMunicipio);
		this.codigoEstado= new SimpleIntegerProperty(codigoEstado);
	}
	
	public IntegerProperty codigoMunicipioProperty() {
		return codigoMunicipio;
	}

	public int getCodigoMunicipio() {
		return codigoMunicipio.get();
	}
	
	public void setCodigoMunicipio(int codigoMunicipio) {
		this.codigoMunicipio= new SimpleIntegerProperty(codigoMunicipio);
	}

	public StringProperty nombreMunicipioProperty() {
		return nombreMunicipio;
	}
	
	public String getNombreMunicipio() {
		return nombreMunicipio.get();
	}
	
	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio= new SimpleStringProperty(nombreMunicipio);
	}
	
	public IntegerProperty codigoEstadoProperty() {
		return codigoEstado;
	}

	public int getCodigoEstado() {
		return codigoEstado.get();
	}
	
	public void setCodigoEstado(int codigoEstado) {
		this.codigoEstado= new SimpleIntegerProperty(codigoEstado);
	}
	
	@Override
	public String toString() {
		return nombreMunicipio.get();
	}	
}
