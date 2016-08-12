package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EstadoCivil {
	private IntegerProperty codigoEstadoCivil;
	private StringProperty nombreEstadoCivil;
	
	public EstadoCivil(int codigoEstadoCivil, String nombreEstadoCivil){
		this.codigoEstadoCivil= new SimpleIntegerProperty(codigoEstadoCivil);
		this.nombreEstadoCivil= new SimpleStringProperty(nombreEstadoCivil);		
	}

	public IntegerProperty codigoEstadoCivilProperty() {
		return codigoEstadoCivil;
	}

	public int getCodigoEstadoCivil() {
		return codigoEstadoCivil.get();
	}
	
	public void setCodigoEstadoCivil(int codigoEstadoCivil) {
		this.codigoEstadoCivil= new SimpleIntegerProperty(codigoEstadoCivil);
	}

	public StringProperty nombreEstadoCivilProperty() {
		return nombreEstadoCivil;
	}
	
	public String getNombreEstadoCivil() {
		return nombreEstadoCivil.get();
	}
	
	public void setNombreEstadoCivil(String nombreEstadoCivil) {
		this.nombreEstadoCivil= new SimpleStringProperty(nombreEstadoCivil);
	}
	
	@Override
	public String toString() {
		return nombreEstadoCivil.get();
	}	
}
