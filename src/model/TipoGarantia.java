package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TipoGarantia {
	private IntegerProperty codigoTipoGarantia;
	private StringProperty tipoGarantia;
	
	public TipoGarantia(int codigoTipoGarantia, String tipoGarantia){
		this.codigoTipoGarantia= new SimpleIntegerProperty(codigoTipoGarantia);
		this.tipoGarantia= new SimpleStringProperty(tipoGarantia);		
	}

	public IntegerProperty codigoTipoGarantiaProperty() {
		return codigoTipoGarantia;
	}

	public int getCodigoTipoGarantia() {
		return codigoTipoGarantia.get();
	}
	
	public void setCodigoTipoGarantia(int codigoTipoGarantia) {
		this.codigoTipoGarantia= new SimpleIntegerProperty(codigoTipoGarantia);
	}

	public StringProperty tipoGarantiaProperty() {
		return tipoGarantia;
	}
	
	public String getTipoGarantia() {
		return tipoGarantia.get();
	}
	
	public void setTipoGarantia(String tipoGarantia) {
		this.tipoGarantia= new SimpleStringProperty(tipoGarantia);
	}
	
	@Override
	public String toString() {
		return tipoGarantia.get();
	}	
}
