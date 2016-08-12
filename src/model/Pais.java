package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Pais {
	private IntegerProperty codigoPais;
	private StringProperty nombrePais;
	
	public Pais(int codigoPais, String nombrePais){
		this.codigoPais= new SimpleIntegerProperty(codigoPais);
		this.nombrePais= new SimpleStringProperty(nombrePais);		
	}

	public IntegerProperty codigoPaisProperty() {
		return codigoPais;
	}

	public int getCodigoPais() {
		return codigoPais.get();
	}
	
	public void setCodigoPais(int codigoPais) {
		this.codigoPais= new SimpleIntegerProperty(codigoPais);
	}

	public StringProperty nombrePaisProperty() {
		return nombrePais;
	}
	
	public String getNombrePais() {
		return nombrePais.get();
	}
	
	public void setNombrePais(String nombrePais) {
		this.nombrePais= new SimpleStringProperty(nombrePais);
	}
	
	@Override
	public String toString() {
		return nombrePais.get();
	}	
}
