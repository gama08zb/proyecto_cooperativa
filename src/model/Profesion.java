package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Profesion {
	private IntegerProperty codigoProfesion;
	private StringProperty nombreProfesion;
	
	public Profesion(int codigoProfesion, String nombreProfesion){
		this.codigoProfesion= new SimpleIntegerProperty(codigoProfesion);
		this.nombreProfesion= new SimpleStringProperty(nombreProfesion);		
	}

	public IntegerProperty codigoProfesionProperty() {
		return codigoProfesion;
	}

	public int getCodigoProfesion() {
		return codigoProfesion.get();
	}
	
	public void setCodigoProfesion(int codigoProfesion) {
		this.codigoProfesion= new SimpleIntegerProperty(codigoProfesion);
	}

	public StringProperty nombreProfesionProperty() {
		return nombreProfesion;
	}
	
	public String getNombreProfesion() {
		return nombreProfesion.get();
	}
	
	public void setNombreProfesion(String nombreProfesion) {
		this.nombreProfesion= new SimpleStringProperty(nombreProfesion);
	}
	
	@Override
	public String toString() {
		return nombreProfesion.get();
	}	
}
