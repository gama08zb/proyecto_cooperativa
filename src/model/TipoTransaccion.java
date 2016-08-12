package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TipoTransaccion {
	private IntegerProperty codigoTipoTransaccion;
	private StringProperty tipoTransaccion;
	
	public TipoTransaccion(int codigoTipoTransaccion, String tipoTransaccion){
		this.codigoTipoTransaccion= new SimpleIntegerProperty(codigoTipoTransaccion);
		this.tipoTransaccion= new SimpleStringProperty(tipoTransaccion);		
	}

	public IntegerProperty codigoTipoTransaccionProperty() {
		return codigoTipoTransaccion;
	}

	public int getCodigoTipoTransaccion() {
		return codigoTipoTransaccion.get();
	}
	
	public void setCodigoTipoTransaccion(int codigoTipoTransaccion) {
		this.codigoTipoTransaccion= new SimpleIntegerProperty(codigoTipoTransaccion);
	}

	public StringProperty tipoTransaccionProperty() {
		return tipoTransaccion;
	}
	
	public String getTipoTransaccion() {
		return tipoTransaccion.get();
	}
	
	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion= new SimpleStringProperty(tipoTransaccion);
	}
	
	@Override
	public String toString() {
		return codigoTipoTransaccion.get() + "\t\t"
				+ tipoTransaccion.get();
	}	
}
