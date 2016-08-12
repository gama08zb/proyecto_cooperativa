package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EstadoPrestamo {
	private IntegerProperty codigoEstadoPrestamo;
	private StringProperty nombreEstadoPrestamo;
	
	public EstadoPrestamo(int codigoEstadoPrestamo, String nombreEstadoPrestamo){
		this.codigoEstadoPrestamo= new SimpleIntegerProperty(codigoEstadoPrestamo);
		this.nombreEstadoPrestamo= new SimpleStringProperty(nombreEstadoPrestamo);		
	}

	public IntegerProperty codigoEstadoPrestamoProperty() {
		return codigoEstadoPrestamo;
	}

	public int getCodigoEstadoPrestamo() {
		return codigoEstadoPrestamo.get();
	}
	
	public void setCodigoEstadoPrestamo(int codigoEstadoPrestamo) {
		this.codigoEstadoPrestamo= new SimpleIntegerProperty(codigoEstadoPrestamo);
	}

	public StringProperty nombreEstadoPrestamoProperty() {
		return nombreEstadoPrestamo;
	}
	
	public String getNombreEstadoPrestamo() {
		return nombreEstadoPrestamo.get();
	}
	
	public void setNombreEstadoPrestamo(String nombreEstadoPrestamo) {
		this.nombreEstadoPrestamo= new SimpleStringProperty(nombreEstadoPrestamo);
	}
	
	@Override
	public String toString() {
		return codigoEstadoPrestamo.get() + "\t\t"
				+ nombreEstadoPrestamo.get();
	}	
}
