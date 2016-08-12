package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Colonia {
	private IntegerProperty codigoColonia;
	private StringProperty nombreColonia;
	private IntegerProperty codigoMunicipio;
	
	public Colonia(int codigoColonia, String nombreColonia){
		this.codigoColonia= new SimpleIntegerProperty(codigoColonia);
		this.nombreColonia= new SimpleStringProperty(nombreColonia);		
	}
	
	public Colonia(int codigoColonia,int codigoMunicipio, String nombreColonia){
		this.codigoMunicipio= new SimpleIntegerProperty(codigoMunicipio);
		this.nombreColonia= new SimpleStringProperty(nombreColonia);
		this.codigoColonia= new SimpleIntegerProperty(codigoColonia);
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

	public StringProperty nombreColoniaProperty() {
		return nombreColonia;
	}
	
	public String getNombreColonia() {
		return nombreColonia.get();
	}
	
	public void setNombreColonia(String nombreColonia) {
		this.nombreColonia= new SimpleStringProperty(nombreColonia);
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
	
	@Override
	public String toString() {
		return nombreColonia.get();
	}	
}
