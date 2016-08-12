package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TipoTrabajo {
	private IntegerProperty codigoTipoTrabajo;
	private StringProperty nombreTipoTrabajo;
	
	public TipoTrabajo(int codigoTipoTrabajo, String nombreTipoTrabajo){
		this.codigoTipoTrabajo= new SimpleIntegerProperty(codigoTipoTrabajo);
		this.nombreTipoTrabajo= new SimpleStringProperty(nombreTipoTrabajo);		
	}

	public IntegerProperty codigoTipoTrabajoProperty() {
		return codigoTipoTrabajo;
	}

	public int getCodigoTipoTrabajo() {
		return codigoTipoTrabajo.get();
	}
	
	public void setCodigoTipoTrabajo(int codigoTipoTrabajo) {
		this.codigoTipoTrabajo= new SimpleIntegerProperty(codigoTipoTrabajo);
	}

	public StringProperty nombreTipoTrabajoProperty() {
		return nombreTipoTrabajo;
	}
	
	public String getNombreTipoTrabajo() {
		return nombreTipoTrabajo.get();
	}
	
	public void setNombreTipoTrabajo(String nombreTipoTrabajo) {
		this.nombreTipoTrabajo= new SimpleStringProperty(nombreTipoTrabajo);
	}
	
	@Override
	public String toString() {
		return nombreTipoTrabajo.get();
	}	
}
