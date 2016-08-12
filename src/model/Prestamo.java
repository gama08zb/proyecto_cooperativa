package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Prestamo {
	private IntegerProperty codigoPrestamo;
	private IntegerProperty codigoEstadoPrestamo;
	private Date fechaInicial;
	private Date fechaFinal;
	
	public Prestamo(int codigoPrestamo, int codigoEstadoPrestamo,Date fechaInicial, Date fechaFinal){
		this.codigoPrestamo= new SimpleIntegerProperty(codigoPrestamo);
		this.codigoEstadoPrestamo= new SimpleIntegerProperty(codigoEstadoPrestamo);
		this.fechaInicial=fechaInicial;
		this.fechaFinal=fechaFinal;
	}

	public IntegerProperty codigoPrestamoProperty() {
		return codigoPrestamo;
	}

	public int getCodigoPrestamo() {
		return codigoPrestamo.get();
	}
	
	public void setCodigoPrestamo(int codigoPrestamo) {
		this.codigoPrestamo= new SimpleIntegerProperty(codigoPrestamo);
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
	
	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	@Override
	public String toString() {
		return codigoPrestamo.get() + "\t\t"
				;
	}	
}
