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
	private DoubleProperty saldo;
	private DoubleProperty interes;
	private DoubleProperty tasaInteres;
	private IntegerProperty plazoMeses;
	private DoubleProperty pagoCapital;
	private DoubleProperty montoSolicitado;
	public PagoPrestamo(){}
	public PagoPrestamo(String nombreCliente,int codigoFormaPago, double tasaInteres, int plazoMeses, double montoSolicitado ){
		this.nombreCliente= new  SimpleStringProperty(nombreCliente);
		this.codigoFormaPago=new  SimpleIntegerProperty(codigoFormaPago);
		this.tasaInteres= new  SimpleDoubleProperty(tasaInteres);
		this.plazoMeses = new  SimpleIntegerProperty(plazoMeses);
		this.montoSolicitado= new  SimpleDoubleProperty(montoSolicitado);
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
	
	public DoubleProperty saldoProperty() {
		return saldo;
	}

	public double getSaldo() {
		return saldo.get();
	}
	
	public void setSaldo(double saldo) {
		this.saldo= new SimpleDoubleProperty(saldo);
	}
	
	public DoubleProperty interesProperty() {
		return interes;
	}

	public double getInteres() {
		return interes.get();
	}
	
	public void setInteres(double interes) {
		this.interes= new SimpleDoubleProperty(interes);
	}
	
	public DoubleProperty pagoCapitalProperty() {
		return pagoCapital;
	}

	public double getPagoCapital() {
		return pagoCapital.get();
	}
	
	public void setPagoCapital(double pagoCapital) {
		this.pagoCapital= new SimpleDoubleProperty(pagoCapital);
	}
	
	public DoubleProperty tasaInteresProperty() {
		return tasaInteres;
	}

	public double getTasaInteres() {
		return tasaInteres.get();
	}
	
	public void setTasaInteres(double tasaInteres) {
		this.tasaInteres= new SimpleDoubleProperty(tasaInteres);
	}
	
	public IntegerProperty plazoMesesProperty() {
		return plazoMeses;
	}

	public int getPlazoMeses() {
		return plazoMeses.get();
	}
	
	public void setPlazoMeses(int plazoMeses) {
		this.plazoMeses= new SimpleIntegerProperty(plazoMeses);
	}
	
	public DoubleProperty montoSolicitadoProperty() {
		return montoSolicitado;
	}

	public double getMontoSolicitado() {
		return montoSolicitado.get();
	}
	
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado= new SimpleDoubleProperty(montoSolicitado);
	}
	
}
