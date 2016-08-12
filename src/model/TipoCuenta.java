package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TipoCuenta {
	private IntegerProperty codigoTipoCuenta;
	private StringProperty tipoCuenta;
	
	public TipoCuenta(int codigoTipoCuenta, String tipoCuenta){
		this.codigoTipoCuenta= new SimpleIntegerProperty(codigoTipoCuenta);
		this.tipoCuenta= new SimpleStringProperty(tipoCuenta);		
	}

	public IntegerProperty codigoTipoCuentaProperty() {
		return codigoTipoCuenta;
	}

	public int getCodigoTipoCuenta() {
		return codigoTipoCuenta.get();
	}
	
	public void setCodigoTipoCuenta(int codigoTipoCuenta) {
		this.codigoTipoCuenta= new SimpleIntegerProperty(codigoTipoCuenta);
	}

	public StringProperty tipoCuentaProperty() {
		return tipoCuenta;
	}
	
	public String getTipoCuenta() {
		return tipoCuenta.get();
	}
	
	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta= new SimpleStringProperty(tipoCuenta);
	}
	
	@Override
	public String toString() {
		return tipoCuenta.get();
	}	
}
