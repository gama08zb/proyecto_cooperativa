package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cargo {
	private IntegerProperty codigoCargo;
	private IntegerProperty codigoTipoTrabajo;
	private StringProperty nombreCargo;
	
	public Cargo(int codigoCargo, String nombreCargo){
		this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
		this.nombreCargo= new SimpleStringProperty(nombreCargo);		
	}

	public Cargo(int codigoCargo,int codigoTipoTrabajo ,String nombreCargo){
		this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
		this.nombreCargo= new SimpleStringProperty(nombreCargo);		
	}
	
	public IntegerProperty codigoCargoProperty() {
		return codigoCargo;
	}

	public int getCodigoCargo() {
		return codigoCargo.get();
	}
	
	public void setCodigoCargo(int codigoCargo) {
		this.codigoCargo= new SimpleIntegerProperty(codigoCargo);
	}

	public StringProperty nombreCargoProperty() {
		return nombreCargo;
	}
	
	public String getNombreCargo() {
		return nombreCargo.get();
	}
	
	public void setNombreCargo(String nombreCargo) {
		this.nombreCargo= new SimpleStringProperty(nombreCargo);
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

	@Override
	public String toString() {
		return nombreCargo.get();
	}	
}
