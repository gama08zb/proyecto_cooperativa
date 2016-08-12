package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FormaPago {
	private IntegerProperty codigoFormaPago;
	private StringProperty formaPago;
	
	public FormaPago(int codigoFormaPago, String formaPago){
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
		this.formaPago= new SimpleStringProperty(formaPago);		
	}

	public IntegerProperty codigoFormaPagoProperty() {
		return codigoFormaPago;
	}

	public int getCodigoFormaPago() {
		return codigoFormaPago.get();
	}
	
	public void setCodigoFormaPago(int codigoFormaPago) {
		this.codigoFormaPago= new SimpleIntegerProperty(codigoFormaPago);
	}

	public StringProperty formaPagoProperty() {
		return formaPago;
	}
	
	public String getFormaPago() {
		return formaPago.get();
	}
	
	public void setFormaPago(String formaPago) {
		this.formaPago= new SimpleStringProperty(formaPago);
	}
	
	@Override
	public String toString() {
		return formaPago.get();
	}	
}
