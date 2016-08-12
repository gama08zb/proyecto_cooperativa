package model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CuentaAhorro {
	private IntegerProperty codigoCuentaAhorro;
	private Date fechaInicial;
	private Date fechaFinalizacion;
	public CuentaAhorro(int codigoCuentaAhorro, Date fechaInicial){
		this.codigoCuentaAhorro= new SimpleIntegerProperty(codigoCuentaAhorro);
		this.fechaInicial=fechaInicial;
	}

	public IntegerProperty codigoCuentaAhorroProperty() {
		return codigoCuentaAhorro;
	}

	public int getCodigoCuentaAhorro() {
		return codigoCuentaAhorro.get();
	}
	
	public void setCodigoCuentaAhorro(int codigoCuentaAhorro) {
		this.codigoCuentaAhorro= new SimpleIntegerProperty(codigoCuentaAhorro);
	}

	
	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public Date getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	@Override
	public String toString() {
		return codigoCuentaAhorro.get() + "\t\t"
				;
	}	
}
