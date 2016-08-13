package model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PagoPrestamo {
	private DoubleProperty cuota;
	private StringProperty nombreCliente;
	private IntegerProperty codigoFormaPago;
	
	public PagoPrestamo(){}
	public PagoPrestamo(String nombreCliente, double cuota,int codigoFormaPago ){
		this.nombreCliente= new  SimpleStringProperty(nombreCliente);
		this.cuota= new  SimpleDoubleProperty(cuota);
		this.codigoFormaPago=new  SimpleIntegerProperty(codigoFormaPago);
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
	
	public StringProperty nombreClienteProperty() {
		return nombreCliente;
	}

	public String getNombreCliente() {
		return nombreCliente.get();
	}
	
	public void setNomreCliente(String nombreCliente) {
		this.nombreCliente= new SimpleStringProperty(nombreCliente);
	}
	public DoubleProperty coutaProperty() {
		return cuota;
	}

	public double getCuota() {
		return cuota.get();
	}
	
	public void setCuota(double cuota) {
		this.cuota= new SimpleDoubleProperty(cuota);
	}
	
}
